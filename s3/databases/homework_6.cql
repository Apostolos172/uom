--1

MATCH (p:Person {name:"Tom Hanks"})-[:ACTED_IN]->(m:Movie)<-[:ACTED_IN]-(co_actor:Person)
WHERE co_actor.name="Kevin Bacon" or co_actor.name="Meg Ryan"
RETURN m

--2

MATCH (m1:Movie)<-[:ACTED_IN]-(p:Person)-[:ACTED_IN]->(m2:Movie)
WHERE m1.title="Snow Falling on Cedars" and m2.title="The Green Mile" 
RETURN p.name, p.born

--3

MATCH (p:Person)-[:ACTED_IN]->(m:Movie)<-[:ACTED_IN]-(co_actor:Person)
WHERE  p.name="Tom Cruise"
WITH collect(co_actor) as co_actors_of_Tom_Cruise

MATCH (p:Person)-[:ACTED_IN]->(m:Movie)<-[:ACTED_IN]-(co_actor:Person)
WHERE  p.name="Kevin Bacon" or p.name="Tom Hanks"
WITH co_actors_of_Tom_Cruise, collect(co_actor) as co_actors_of_Kevin_Bacon

RETURN [Person IN co_actors_of_Tom_Cruise WHERE NOT Person 
IN co_actors_of_Kevin_Bacon AND Person.name<>"Kevin Bacon"] AS final

--4

MATCH (p:Person)-[:ACTED_IN]->(m:Movie)<-[:ACTED_IN]-(co_actor:Person)-[:ACTED_IN]->
(m1:Movie {title:"A Few Good Men"})
RETURN m.title,count(*) as actors
ORDER BY actors DESC

--5

MATCH (p:Person)
WITH collect(p) as all_people

MATCH (p:Person)-[:ACTED_IN]->(m:Movie) 
WITH all_people, collect(p) as actors

RETURN [Person IN all_people WHERE NOT Person IN actors ] AS not_actors