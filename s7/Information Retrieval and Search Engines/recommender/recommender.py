
# εισαγωγή βιβλιοθηκών
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.metrics.pairwise import cosine_similarity
from sklearn.preprocessing import MinMaxScaler

# ορισμός συναρτήσεων
def l():
    print('\n')
    
def precision(relevantRetrieved, retrieved):
    # precision
    # true positives / (true positives + false positives)
    precision = relevantRetrieved/retrieved
    precision = round(precision, 2)
    precision = ''+str(relevantRetrieved)+'/'+str(retrieved)
    return precision
    
def recall(relevantRetrieved, relevant):
    # recall
    # true positives / (true positives + false negatives)
    recall = relevantRetrieved/relevant
    recall = round(recall, 2)
    recall = ''+str(relevantRetrieved)+'/'+str(relevant)
    return recall
    
def mae(predictionsVector, rankingsInTestSetVector, n):
    # Mean abslute error
    mae = np.abs(predictionsVector - rankingsInTestSetVector).sum().sum()/n
    mae = round(mae, 2)
    # mae = np.abs(predictionsVector - rankingsInTestSetVector).sum().sum()
    # mae = ''+str(mae)+'/'+str(n)
    return mae

# --------------------------------------------------------------------------------------

# for csv management
from csv import reader

# δημιουργία λεξικού και αρχικοποίηση για καταμέτρηση κριτικών ανά ταινία
moviesRatingsCount = {}
# open file in read mode
with open('links.csv', 'r') as read_obj:
    # pass the file object to reader() to get the reader object
    csv_reader = reader(read_obj)
    # This skips the first row of the CSV file.
    next(csv_reader)
    # Iterate over each row in the csv using reader object
    for row in csv_reader:
        # row variable is a list that represents a row in csv
        movieId = row[0]
        moviesRatingsCount[movieId] = 0

# μέτρηση βαθμολογήσεων κάθε ταινίας
with open('ratings.csv', 'r') as read_obj:
    csv_reader = reader(read_obj)
    next(csv_reader)
    # Iterate over each row in the csv using reader object
    for row in csv_reader:
        # row variable is a list that represents a row in csv
        movieId = row[1]
        temp_count = int(moviesRatingsCount[movieId])
        temp_count = temp_count + 1
        moviesRatingsCount[movieId] = temp_count

# χρήση νέου λεξικού moviesRatingsCountFinal που θα περιλαμβάνει μόνο τις ταινίες με πάνω από 4 κριτικές
moviesRatingsCountFinal = moviesRatingsCount.copy()

for id in moviesRatingsCount:
    if moviesRatingsCount[id]<5:
        del moviesRatingsCountFinal[id]
del moviesRatingsCount
# μετατροπή των κλειδιών, τιμών του λεξικού σε ακεραίους
moviesRatingsCountFinal = {int(k):int(v) for k,v in moviesRatingsCountFinal.items()}

# το λεξικό είναι έτοιμο και χρειαζόμαστε τα κλειδιά
finalMovies = moviesRatingsCountFinal.keys()
#print (finalMovies)

# loading csv file into pandas dataframe

# specify path
my_path = ""
# read ratings file
ratings = pd.read_csv(my_path + 'ratings.csv')

#print(ratings.head())
#print(ratings.tail())
l()
print("initial shape of dataframe",ratings.shape)

"""
παίρνω τα κλειδιά του λεξικού όπου περιέχονται όσες ταινίες είναι με τουλάχιστον 5 κριτικές
διατρέχω dataframe και αν υπάρχει το movieId μέσα στο λεξικό τότε κρατώ την σειρά του dataframe
"""
df_filtered = ratings[ratings["movieId"].isin(finalMovies)]
print("reduced shape",df_filtered.shape)

print('Προεπεξεργασία τελείωσε, 1 τελείωσε')
l()

# ------------- 1ο βήμα τέλος ------------------------

# Train-test split

testSize = 0.10
trainSize = 0.9
X_train, X_test = train_test_split(df_filtered, test_size = testSize, train_size = trainSize, random_state = 42)

print('train shape',X_train.shape)
print('test shape',X_test.shape)

print('Χωρισμός σετ τελείωσε, 2 τελείωσε')
l()

# --------------------------------------------------------------------------------------

# make a copy of test dataset
dummy_test = X_test.copy()

# Στόχος μας στο τεστ σετ να προβλέψουμε βαθμολογήσεις για ταινίες που ήδη έχουν βαθμολογήσει 
    # οι χρήστες ούτως ώστε να αποτιμήσουμε το σύστημα. 
    # Οπότε χρησιμοποιούμε ένα dummy test set για να ξέρουμε ποιες θέσεις είναι αυτές (1)
dummy_test['rating'] = dummy_test['rating'].apply(lambda x: 1 if x > 0 else 0)

# The movies not rated by user is marked as 0 for evaluation 
dummy_test = dummy_test.pivot(index ='userId', columns = 'movieId', values = 'rating').fillna(0)

# --------------------------------------------------------------------------------------

# υπολογισμός user-user cosine similarity
test_user_features = X_test.pivot(index = 'userId', columns = 'movieId', values = 'rating').fillna(0)
test_user_similarity = cosine_similarity(test_user_features)
test_user_similarity[np.isnan(test_user_similarity)] = 0
user_similarity = pd.DataFrame(test_user_similarity)

# υπολογισμός πρόβλεψης όχι με συνάρτηση πρόβλεψης σταθμισμένου μέσου όρου όπως ζητείται
    # αλλά με χρήση απλού εσωτερικού γινομένου
user_predicted_ratings_test = np.dot(user_similarity, test_user_features)
#print(user_predicted_ratings_test)

# Επιλογή μόνο των ταινιών που ήδη βαθμολόγησε ο χρήστης
test_user_final_rating = np.multiply(user_predicted_ratings_test, dummy_test)

# Κανονικοποίση των προβλέψεων βαθμολογιών στην κλίμακα που θέλουμε καθώς δεν αξιοποιήθηκε η ανάλογη συνάρτηση πρόβλεψης (0.5, 5)
X = test_user_final_rating.copy() 
X = X[X > 0] # only consider non-zero values as 0 means the user haven't rated the movies
scaler = MinMaxScaler(feature_range = (0.5, 5))
scaler.fit(X)
pred = scaler.transform(X)

# total non-NaN value
total_non_nan = np.count_nonzero(~np.isnan(pred))

# test set
test = X_test.pivot(index = 'userId', columns = 'movieId', values = 'rating')

# test and predictions
preds = pd.DataFrame(pred)
testS = test.to_numpy()
testset = pd.DataFrame(testS)
print('test set')
print(testset)
l()
print('predictions for the test set')
print(preds)

#έχουμε τεστ σετ και τις προβλέψεις γι αυτό, πάμε σε αποτίμηση
retrieved = total_non_nan
relevant = 0
for rank in test:
    if rank>3.5:
        relevant+=1

# true positives: όσα είναι σχετικά στο test set, αν είναι σχετικά και στο pred set τότε true positives
tp = 0
for i in range(len(test.index)):
    for j in range(2688):
        # Για τον υπολογισμό των δυαδικών μέτρων αποτίμησης θεωρείστε μια ταινία ως
            # σχετική αν ο πραγματικός της βαθμός είναι >3.5
        if (testset.loc[i,j] > 3.5 and preds.loc[i,j] > 3.5):
            tp+=1

l()
print('Αποτίμηση συστήματος')
print('Mean absolute error',mae(pred,test,total_non_nan))
print('precision',precision(tp,retrieved))
print('recall',recall(tp,relevant))
l()
