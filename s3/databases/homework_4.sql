-- 1)

SELECT DISTINCT t.passenger_id, t.passenger_name, t.contact_data
FROM tickets t
WHERE t.book_ref LIKE '%CA%' 
	AND (t.passenger_name LIKE 'ADELINA%' OR t.passenger_name LIKE '%ANDREEVA');
	
-- 2) 

SELECT t.passenger_name, b.book_date
FROM tickets t JOIN bookings b ON b.book_ref=t.book_ref
WHERE book_date IN (
		SELECT MIN(book_date)
		FROM bookings);
		
-- 3) 

SELECT tic.passenger_name, total_cost
FROM (SELECT t.passenger_id, SUM(tf.amount) AS total_cost
FROM tickets t JOIN ticket_flights tf ON t.ticket_no=tf.ticket_no
GROUP BY t.passenger_id
HAVING COUNT(*)>=5 AND SUM(tf.amount)>350000) AS TEMP JOIN tickets tic on TEMP.passenger_id=tic.passenger_id;

-- 4) 

SELECT a_c.aircraft_code, a_c.model, a_c.range
FROM (	SELECT DISTINCT fl.aircraft_code
		FROM flights AS fl
		WHERE (fl.status LIKE 'Delayed' AND (fl.departure_airport IN (
			SELECT a_p.airport_code
			FROM airports AS a_p
			WHERE a_p.airport_name LIKE 'Ulyanovsk%')
			OR fl.arrival_airport IN
			(SELECT a_p.airport_code 
			FROM airports AS a_p
			WHERE a_p.airport_name LIKE 'Ulyanovsk%')	))) AS TEMP JOIN aircrafts a_c ON TEMP.aircraft_code=a_c.aircraft_code;
			
-- 5) 

SELECT passenger_name
FROM tickets 
WHERE ticket_no IN (
	SELECT ti.ticket_no
	FROM ticket_flights ti
	WHERE ti.fare_conditions LIKE 'Economy' AND flight_id IN (
		SELECT f.flight_id
		FROM flights AS f 
		WHERE f.arrival_airport IN (
			SELECT a_p.airport_code 
			FROM airports AS a_p
			WHERE a_p.city LIKE 'Krasnoyarsk')
	)
)	AND ticket_no IN (
	SELECT ticket_no
	FROM ticket_flights
	GROUP BY ticket_no
	HAVING COUNT(*)=1
	)
	AND passenger_name IN (
	SELECT passenger_name
	FROM tickets
	GROUP BY passenger_name
	HAVING COUNT(*)=1
	)
ORDER BY passenger_name;

-- 6) 

SELECT flightsOfAircrafts.aircraft_code, flightsOfAircrafts.model, flightsOfAircrafts.number_of_flights
FROM (
		(
		SELECT temp.aircraft_code, a_c.model, temp.number_of_flights
		FROM aircrafts AS a_c JOIN (
			SELECT f_v.aircraft_code, COUNT(*) AS number_of_flights
			FROM flights_v AS f_v
			GROUP BY f_v.aircraft_code
			) AS temp ON a_c.aircraft_code=temp.aircraft_code
		ORDER BY temp.number_of_flights 
		)
		UNION
		(
		SELECT a_c.aircraft_code, a_c.model, 0 AS number_of_flights
		FROM aircrafts AS a_c
		WHERE a_c.aircraft_code NOT IN (
			SELECT temp.aircraft_code
			FROM (
				SELECT f_v.aircraft_code, COUNT(*) AS number_of_flights
				FROM flights_v AS f_v
				GROUP BY f_v.aircraft_code
				) AS temp 
			ORDER BY temp.number_of_flights 
			)
		)
	) AS flightsOfAircrafts
ORDER BY flightsOfAircrafts.number_of_flights; 

-- 7) 

SELECT f.flight_id, f.departure_airport, f.arrival_airport
FROM flights AS f
WHERE f.status LIKE 'Cancelled' AND f.aircraft_code IN (
    SELECT temp.aircraft_code 
	FROM (
		SELECT s.aircraft_code, COUNT(*) AS seats_of_the_plane
		FROM seats AS s
		GROUP BY s.aircraft_code
		HAVING COUNT(*)>50
		ORDER BY seats_of_the_plane
		)AS temp
);

-- 8) 

SELECT aircraft_code
FROM aircrafts
WHERE aircraft_code IN (
	SELECT aircraft_code
	FROM(
		SELECT departure_airport, aircraft_code
		FROM flights
		WHERE departure_airport IN(
			SELECT airport_code
			FROM airports
			WHERE city LIKE 'L%'
			)
		) AS temp
);

-- 9) 

SELECT airport_name AS departure_airport_name
FROM airports
WHERE airport_code IN (
	SELECT departure_airport
	FROM (
		SELECT departure_airport, COUNT(*) AS flights
		FROM flights_v
		WHERE status LIKE 'Cancelled'
		GROUP BY departure_airport
		) AS temp1
	WHERE flights IN (
		SELECT MIN(flights)
		FROM (
		SELECT departure_airport, COUNT(*) AS flights
		FROM flights_v
		WHERE status LIKE 'Cancelled' AND scheduled_departure > '2017-07-31'
		GROUP BY departure_airport
		) AS temp2
		)
	);

-- 10) 

SELECT departure_city, arrival_city, COUNT(*) AS number_of_routes
FROM routes
WHERE departure_city < arrival_city
GROUP BY departure_city, arrival_city
HAVING COUNT(*)>2
ORDER BY departure_city;
