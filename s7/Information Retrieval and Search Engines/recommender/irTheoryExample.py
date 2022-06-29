
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
    jaccard = round(jaccard,2)
    
    return jaccard
    
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
    
def predictiveFunction(k, sim, r):
    # συνάρτηση πρόβλεψης 
    # αποτελεί τον σταθμισμένο μέσο όρο των Κ κοντινότερων γειτόνων
        
    similarities = 0
    sumSimR = 0
    for d in range(0,k):
        similarities = similarities + sim[d]
        sumSimR = sumSimR + (sim[d]*r[d])
    predictedRank = sumSimR/similarities
    predictedRank = round(predictedRank,1)
    predictedRank = round(predictedRank,0)
    
    return predictedRank

"""
# jaccard similarity test
l()
print('random example:')
rankingX = [1,1,1,0,1]
rankingY = [1,0,1,1,1]
print('jaccard:', jaccard(rankingX, rankingY))
print('3/5:', 3/5)
l()
"""

# item-item collaborative filtering system
item1 = [3, 4, 3, 1]
item2 = [1, 3, 3, 5]
item3 = [2, 4, 1, 5]
item4 = [3, 3, 5, 2]

item5 = [3, 5, 4, 1]

l()
print('Πρόβλεψη με item-item collaborative filtering system')
print('adjusted cosine v1, v5:', adjustedCosine(item1,item5))
print('adjusted cosine v2, v5:', adjustedCosine(item2,item5))
print('adjusted cosine v3, v5:', adjustedCosine(item3,item5))
print('adjusted cosine v4, v5:', adjustedCosine(item4,item5))
k=2
sim = [adjustedCosine(item1,item5),adjustedCosine(item4,item5)]
r = [5,4]
print('Πρόβλεψη',predictiveFunction(k, sim, r))
l()

# user-user collaborative filtering system
user1 = [3, 1, 2, 3]
user2 = [4, 3, 4, 3]
user3 = [3, 3, 1, 5]
user4 = [1, 5, 5, 2]

alice = [5, 3, 4, 4]

l()
print('Πρόβλεψη με user-user collaborative filtering system')
print('adjusted cosine v1, alice:', adjustedCosine(user1,alice))
print('adjusted cosine v2, alice:', adjustedCosine(user2,alice))
print('adjusted cosine v3, alice:', adjustedCosine(user3,alice))
print('adjusted cosine v4, alice:', adjustedCosine(user4,alice))
k=2
sim = [adjustedCosine(user1,alice),adjustedCosine(user2,alice)]
r = [3,5]
print('Πρόβλεψη',predictiveFunction(k, sim, r))
l()
