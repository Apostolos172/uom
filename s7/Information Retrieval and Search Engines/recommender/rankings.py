
def keyExists(dict, key):
    # returns if key is in dictionary  
    if key in dict.keys():
        return True
    else:
        return False

def hr():
  print('─' * 20)
  
def l():
    print('\n')

def _():
  l()
  hr()
  l()

def jaccard(v1,v2):
    # πρώτη συνάρτηση ομοιότητας, jaccard
    
    union = len(v1)
    count = 0
    for i in range(len(v1)):
        if(v1[i]):
            if(v2[i]):
                count = count + 1
    
    jaccard = count/union
    jaccard = round(jaccard,5)
    
    return jaccard
    
l()
rankingX = [1,1,1,0,1]
rankingY = [1,0,1,1,1]
print('jaccard:', jaccard(rankingX, rankingY))
print('3/5:', 3/5)
l()

def subtractTheRowMean(vector):
    # function which subtracts the (row) mean of a vector
    countVector = 0
    for i in range(len(vector)):
        if (vector[i]!=0):
            countVector+=1
    mean = sum(vector)/countVector
    # print(mean)
    for i in range(len(vector)):
        if (vector[i]!=0):
            vector[i] = vector[i]-mean
    return vector

def adjustedCosine(v1, v2):
    # πρώτη συνάρτηση ομοιότητας, adjusted cosine
    
    import math
    
    v1=subtractTheRowMean(v1)
    v2=subtractTheRowMean(v2)
    
    "compute cosine similarity of v1 to v2: (v1 dot v2)/{||v1||*||v2||)"
    sumxx, sumxy, sumyy = 0, 0, 0
    for i in range(len(v1)):
        x = v1[i]
        y = v2[i]
        sumxy += x*y
        sumxx += x*x
        sumyy += y*y
    adjustedCosine = sumxy/math.sqrt(sumxx*sumyy)
    adjustedCosine = round(adjustedCosine,3)
    
    return adjustedCosine

v1 = [4, 0, 0, 5, 1, 0, 0]
v2 = [5, 5, 4, 0, 0, 0, 0]
v3 = [0, 0, 0, 2, 4, 5, 0]

l()
print('adjusted cosine v1, v2:', adjustedCosine(v1,v2))
print('adjusted cosine v1, v3:', adjustedCosine(v1,v3))
l()

def precision(relevantRetrieved, retrieved):
    # precision
    precision = relevantRetrieved/retrieved
    precision = round(precision, 2)
    return precision
    
def recall(relevantRetrieved, relevant):
    # recall
    recall = relevantRetrieved/relevant
    recall = round(recall, 2)
    return recall

def AE(predictedRank, realRank):
    # Απόλυτο Λάθος
    # υπολογίζει την απόκλιση µεταξύ προβλεπόµενων βαθµολογιών και πραγµατικών βαθµολογιών    
    AE = predictedRank - realRank
    AE = abs(AE)
    AE = round(AE, 2)
    return AE
    
def MAE(predictedRankVector, realRankVector):
    # Μέσο Απόλυτο Λάθος
    # υπολογίζει την απόκλιση µεταξύ προβλεπόµενων βαθµολογιών και πραγµατικών βαθµολογιών    
    MAE = 0
    n = len(predictedRankVector)
    for i in range(n):
        MAE = MAE + AE(predictedRankVector[i], realRankVector[i])
    MAE = MAE/n
    MAE = round(MAE, 2)
    return MAE

def sim(c, d):
    # similarity
    
    return 0;

def predictiveFunction(k, sim, r):
    # συνάρτηση πρόβλεψης 
    # αποτελεί τον σταθμισμένο μέσο όρο των Κ κοντινότερων γειτόνων
        
    similarities = 0
    sumSimR = 0
    for d in range(0,k):
        # sim = sim(c, d)
        similarities = similarities + sim[d]
        sumSimR = sumSimR + (sim[d]*r[d])
    predictedRank = sumSimR/similarities
    predictedRank = round(predictedRank,1)
    # similarityVector = []
    
    return predictedRank
    
_()

# for csv management
from csv import reader

# δημιουργία λεξικού και αρχικοποίηση

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
# check
# print(moviesRatingsCount["193609"])

# μέτρηση βαθμολογήσεων κάθε ταινίας

with open('ratings.csv', 'r') as read_obj:
    # pass the file object to reader() to get the reader object
    csv_reader = reader(read_obj)
    next(csv_reader)
    # Iterate over each row in the csv using reader object
    for row in csv_reader:
        # row variable is a list that represents a row in csv
        movieId = row[1]
        temp_count = int(moviesRatingsCount[movieId])
        temp_count = temp_count + 1
        # print(temp_count)
        moviesRatingsCount[movieId] = temp_count
        # print(str(movieId) + ": " + str(moviesRatingsCount[movieId]))
# check
# print(moviesRatingsCount["193609"])
# print(moviesRatingsCount["movieId"])
# print(moviesRatingsCount["170875"])
# print('len: ' + str(len(moviesRatingsCount)))

# σύνολο ελέγχου
checkingSetLength = 0.1*len(moviesRatingsCount)
checkingSetLength = round(checkingSetLength, 0)
checkingSetLength = int(checkingSetLength)

#for id, n in moviesRatingsCount.items():
#  print("movieId", id, ":", n, "ratings")

moviesRatingsCountFinal = moviesRatingsCount.copy()

for id in moviesRatingsCount:
    if moviesRatingsCount[id]<5:
        del moviesRatingsCountFinal[id]

# del moviesRatingsCount
l()
print('Προεπεξεργασία τελείωσε, 1 τελείωσε')

# σύνολο ελέγχου
moviesRatingsCountFinalCheckingSet = moviesRatingsCountFinal.copy()
count = 0
for id in moviesRatingsCountFinal:
    count = count + 1
    if count>checkingSetLength:
        del moviesRatingsCountFinalCheckingSet[id]

moviesRatingsCountFinalTrainingSet = moviesRatingsCountFinal.copy()
count = 0
for id in moviesRatingsCountFinal:
    count = count + 1
    if count<=checkingSetLength:
        del moviesRatingsCountFinalTrainingSet[id]
    else:
        break
"""        
for id, n in moviesRatingsCountFinal.items():
  print("movieId", id, ":", n, "ratings")
"""
l()
print('len (συνόλου δεδομένων με πάνω από 4 βαθμολογήσεις): ' + str(len(moviesRatingsCountFinal)))
print('len Checking Set: ' + str(len(moviesRatingsCountFinalCheckingSet)))
print('len Training Set: ' + str(len(moviesRatingsCountFinalTrainingSet)))
# print('len (add Checking και Training μήκη):', len(moviesRatingsCountFinalCheckingSet)+len(moviesRatingsCountFinalTrainingSet) )

del moviesRatingsCountFinal

l()
print('Έχω και τα δύο σύνολα ταινιών που θα χρησιμοποιήσω ως training και checking set, 2 τελείωσε')
print('σύνολο ελέγχου:', checkingSetLength)


# δημιουργία λίστας χρηστών 

Users = []

# open file in read mode
with open('ratings.csv', 'r') as read_obj:
    # pass the file object to reader() to get the reader object
    csv_reader = reader(read_obj)
    # This skips the first row of the CSV file.
    next(csv_reader)
    # Iterate over each row in the csv using reader object
    userId = -1
    for row in csv_reader:
        # row variable is a list that represents a row in csv
        if userId!=row[0]:
            userId = row[0]
            Users.append(userId)
# check
# print('users:',Users)
print('number of users:',len(Users))
# All selected users, in the dataset, had rated at least 20 movies.

keysCheckingSet = list(moviesRatingsCountFinalCheckingSet.keys())

moviesRatings = {}
for movieId in keysCheckingSet:
    moviesRatings[movieId] = []
# print('moviesRatings', moviesRatings)

tempList = []
for i in range(0,610):
    tempList.append(0)

# moviesRatingsCount dictionary
for movieId in moviesRatingsCount:
    moviesRatingsCount[movieId] = tempList.copy()
    
#for movieId in moviesRatingsCount:
#    print(movieId, ':', moviesRatingsCount[movieId])

# καταγραφή λιστών βαθµολογιών
# open file in read mode
with open('ratings.csv', 'r') as read_obj:
    # pass the file object to reader() to get the reader object
    csv_reader = reader(read_obj)
    # This skips the first row of the CSV file.
    next(csv_reader)
    # Iterate over each row in the csv using reader object
    for row in csv_reader:
        # row variable is a list that represents a row in csv
        movieId = row[1]
        userId = int(row[0])-1
        thislist = moviesRatingsCount[movieId]
        (moviesRatingsCount[movieId])[userId] = 1

for movieId in moviesRatingsCount:
    if keyExists(moviesRatings,movieId):
        moviesRatings[movieId] = moviesRatingsCount[movieId]
"""
for movieId in moviesRatingsCount:
    print(movieId, ':', moviesRatingsCount[movieId])
"""
"""    
for movieId in moviesRatings:
    print(movieId, ':', moviesRatings[movieId])
"""

keysTrainingSet = list(moviesRatingsCountFinalTrainingSet.keys())
# print('movies:',keysTrainingSet)
# Για αυτήν θα προβλέψω βαθμό
firstMovieIdTrainingSet = keysTrainingSet[0]
firstMovieIdTrainingSet = '1967'
firstMovieIdTrainingSet = '2000'
firstMovieIdTrainingSet = '2005'
firstMovieIdTrainingSet = '2012'
firstMovieIdTrainingSet = '2414'
firstMovieIdTrainingSet = '2657' #✖
firstMovieIdTrainingSet = '5060' #✔ 

firstMovieIdTrainingSet = '2617'
firstMovieIdTrainingSet = '3176'

firstMovieIdTrainingSetRanking = tempList.copy()

with open('ratings.csv', 'r') as read_obj:
    # pass the file object to reader() to get the reader object
    csv_reader = reader(read_obj)
    # This skips the first row of the CSV file.
    next(csv_reader)
    # Iterate over each row in the csv using reader object
    for row in csv_reader:
        # row variable is a list that represents a row in csv
        movieId = row[1]
        userId = int(row[0])-1
        if movieId==firstMovieIdTrainingSet:
            firstMovieIdTrainingSetRanking[userId] = 1

# print('firstMovieIdTrainingSetRanking',firstMovieIdTrainingSetRanking)

"""
for movieId in moviesRatingsCount:
    if keyExists(moviesRatings,movieId):
        moviesRatings[movieId] = moviesRatingsCount[movieId]
"""
jaccardRankings = []
for movieId in moviesRatings:
    # πρέπει να δημιουργήσω λίστα βαθµολογιών για να περάσω στην jaccard
    # την δημιούργησα την λίστα είναι παραπάνω - όχι ακριβώς
    v1 = moviesRatings[movieId]
    v2 = firstMovieIdTrainingSetRanking
    jaccardCoef = jaccard(v1,v2)
    #jaccardCoef = adjustedCosine(v1,v2)
    listItem = str(jaccardCoef) + " --> " + str(movieId)
    jaccardRankings.append(listItem)
    #print('sim(',movieId,',',firstMovieIdTrainingSet,'):',jaccardCoef)    
   
k = 5
k = 10
k = 25
k = 50

jaccardRankings.sort(reverse=True)
kNeighbourhoods = jaccardRankings[:k]
kNeighbourhoodsMovies = []
kNeighbourhoodsMoviesRanks = []
for i in range(0,k):
    split = ((kNeighbourhoods[i]).split(" --> "))[1]
    kNeighbourhoodsMovies.append(split)
    kNeighbourhoodsMoviesRanks.append(float(((kNeighbourhoods[i]).split(" --> "))[0]))
l()
print(kNeighbourhoods)
print(kNeighbourhoodsMovies)
userr = {}
for i in range(len(kNeighbourhoodsMovies)):
    userr[(kNeighbourhoodsMovies[i])] = 0 
print(kNeighbourhoodsMoviesRanks)

userSelected = Users[0]
userrrr = []
with open('ratings.csv', 'r') as read_obj:
    # pass the file object to reader() to get the reader object
    csv_reader = reader(read_obj)
    # This skips the first row of the CSV file.
    next(csv_reader)
    # Iterate over each row in the csv using reader object
    for row in csv_reader:
        # row variable is a list that represents a row in csv
        movieId = row[1]
        userId = row[0]
        ranking = float(row[2])
        if userId==userSelected and (movieId in kNeighbourhoodsMovies):
            # κανονικά πρέπει να μπουν στις ίδιες θέσεις
            userrrr.append(ranking)
            userr[movieId] = ranking 
            # print(movieId,ranking)

print(userrrr)
# dictionaries are sorted by the order of item insertion
print(userr)
userrr = list(userr.values())
print(userrr)
"""
# predictiveFunction(k, sim, r)
final = predictiveFunction(k, kNeighbourhoodsMoviesRanks, userrrr)
print('Η πρόβλεψη για την βαθμολόγηση του',userSelected,'για την ταινία',firstMovieIdTrainingSet,
    'είναι',final)
"""
final = predictiveFunction(k, kNeighbourhoodsMoviesRanks, userrr)
l()
print('Η πρόβλεψη για την βαθμολόγηση του',userSelected,'για την ταινία',firstMovieIdTrainingSet,
    'είναι',final)
# '(Better theoretically)'

l()
print('finished')
l()
_()
