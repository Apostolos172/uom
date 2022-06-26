
# Create spark session
from pyspark.sql import SparkSession
spark = SparkSession.builder.getOrCreate()

from pyspark.ml.clustering import KMeans
from pyspark.ml.evaluation import ClusteringEvaluator
from pyspark.ml.clustering import KMeansSummary
from pyspark.ml.feature import VectorAssembler

# Loads data.
dataset = spark.read.format("csv").option("header", "false").option("inferSchema","true").load("hdfs://master:9000/user/user/projects/project2/input/meddata2022.csv")

# Each line-patient data collection in a vector
assemble=VectorAssembler(inputCols=['_c0', '_c1', '_c2', '_c3','_c4'], outputCol='features')
assembled_data=assemble.transform(dataset)

mode = "random"
maxSilhouette = 0
maxSilhouetteK = 0
        
for i in range(2,15):
    kmeansS = KMeansSummary()
    kmeans = KMeans().setK(i)
    kmeans.setInitMode(mode)
    model = kmeans.fit(assembled_data)
    predictions = model.transform(assembled_data)
    evaluator = ClusteringEvaluator()
    silhouette = evaluator.evaluate(predictions)
    print(i,"Silhouette with squared euclidean distance = " + str(silhouette))
    if silhouette>maxSilhouette:
        maxSilhouette = silhouette
        maxSilhouetteK = i
    kmeansS = model.summary
    sizes = kmeansS.clusterSizes
    cost = kmeansS.trainingCost
    print(i,"cost " + str(cost))
    centers = model.clusterCenters()
    print("Cluster Centers: ")
    for j in range(len(centers)):
        print('center of cluster',centers[j])
        print('size of cluster',sizes[j])

print('Το προτεινόμενο πλήθος clusters με αρχικοποίηση random είναι',maxSilhouetteK,'λόγω μέγιστου συντελεστή περιγράμματος',maxSilhouette)

mode = "k-means||"
maxSilhouette = 0
maxSilhouetteK = 0
        
for i in range(2,15):
    kmeansS = KMeansSummary()
    kmeans = KMeans().setK(i)
    kmeans.setInitMode(mode)
    model = kmeans.fit(assembled_data)
    predictions = model.transform(assembled_data)
    evaluator = ClusteringEvaluator()
    silhouette = evaluator.evaluate(predictions)
    print(i,"Silhouette with squared euclidean distance = " + str(silhouette))
    if silhouette>maxSilhouette:
        maxSilhouette = silhouette
        maxSilhouetteK = i
    kmeansS = model.summary
    sizes = kmeansS.clusterSizes
    cost = kmeansS.trainingCost
    print(i,"cost " + str(cost))
    centers = model.clusterCenters()
    print("Cluster Centers: ")
    for j in range(len(centers)):
        print('center of cluster',centers[j])
        print('size of cluster',sizes[j])

print('Το προτεινόμενο πλήθος clusters με αρχικοποίηση k-means|| είναι',maxSilhouetteK,'λόγω μέγιστου συντελεστή περιγράμματος',maxSilhouette)
