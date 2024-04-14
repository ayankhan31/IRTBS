update seatavailability s inner join traincoach tc on tc.train_coach_id = s.train_coach_id 
	inner join coach c on c.coach_id = tc.coach_id 
    set s.seats_available=s.seats_available-3 
    where c.type='3AC' and s.journey_start_date = '2024-04-01' 
	and s.route_id in  (select route_id from route where train_id = 1 and stop_number between (select stop_number from route where train_id =1 and station_id=1) and (select stop_number-1 from route where train_id=1 and station_id=4));
