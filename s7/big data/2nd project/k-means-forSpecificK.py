
# https://spark.apache.org/docs/latest/api/python/getting_started/quickstart_df.html#DataFrame-Creation
from pyspark.sql import SparkSession
spark = SparkSession.builder.getOrCreate()

from pyspark.ml.clustering import KMeans
from pyspark.ml.evaluation import ClusteringEvaluator
from pyspark.ml.clustering import KMeansSummary
from pyspark.ml.feature import VectorAssembler

# Loads data.
dataset = spark.read.format("csv").option("header", "false").option("inferSchema","true").load("hdfs://master:9000/user/user/projects/project2/input/meddata2022.csv")
# https://towardsdatascience.com/spark-essentials-how-to-read-and-write-data-with-pyspark-5c45e29227cd

assemble=VectorAssembler(inputCols=['_c0', '_c1', '_c2', '_c3','_c4'], outputCol='features')
assembled_data=assemble.transform(dataset)

# Trains a k-means model.
kmeans = KMeans().setK(6)
kmeans.setInitMode("k-means||")
model = kmeans.fit(assembled_data)

# Make predictions (to which cluster each point will be assigned)
predictions = model.transform(assembled_data)

# Evaluate clustering by computing Silhouette score
evaluator = ClusteringEvaluator()

silhouette = evaluator.evaluate(predictions)
print("Silhouette with squared euclidean distance = " + str(silhouette))

kmeansS = KMeansSummary()
kmeansS = model.summary
cost = kmeansS.trainingCost
print("cost " + str(cost))

# Shows the result.
centers = model.clusterCenters()
print("Cluster Centers: ")
for center in centers:
    print(center)
