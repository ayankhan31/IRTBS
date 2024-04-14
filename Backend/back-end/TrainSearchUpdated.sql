select tr.train_id, tr.train_name, tr.days, s.journey_start_date, ssn.station_name as source, 
esn.station_name as destination, r1.departure_time as start, r2.arrival_time as reach
from route r1 inner join route r2 on r1.train_id = r2.train_id 
	inner join seatavailability s on  r1.route_id = s.route_id 
    inner join traincoach t on s.train_coach_id = t.train_coach_id
    inner join coach c on t.coach_id = c.coach_id
    inner join train tr on tr.train_id = r1.train_id
    inner join station ssn on ssn.station_id = r1.station_id
    inner join station esn on esn.station_id = r2.station_id
	where r1.station_id = 3 and r2.station_id=1 and r1.stop_number<r2.stop_number and s.journey_start_date='2024-04-02';