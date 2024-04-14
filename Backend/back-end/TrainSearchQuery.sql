 SELECT
     t.train_id,
     t.train_name,
     ssn.station_name AS From_Station,
     esn.station_name AS To_Station,
     
	--  r.arrival_time,
--      r.departure_time,
     t.days AS runs_on_days
 FROM
     train t
 JOIN
     route r ON t.train_id = r.train_id
 JOIN
     station ssn ON t.source_station_id = ssn.station_id
 JOIN
     station esn ON t.end_station_id = esn.station_id     
 where ssn.station_name = 'LUCKNOW - LKO' and esn.station_name = 'GHAZIPUR CITY - GCT'
GROUP BY t.train_id
