/* SEARCH TRAINS BASED ON FROM, TO and DATE */ 

select t.tid, t.tname, t.from, t.to, t.totalseats, t.days, s.departuredate, r1.station, r2.station from routes r1 
inner join routes r2 on r1.tid = r2.tid 
	inner join seats s on r1.rid=s.rid 
		inner join trains t on t.tid=r1.tid 
			where r1.station='Tambaram' and r2.station='Madurai' and s.departuredate='2024-03-30';
            
/* SEARCH TRAINS ROUTE BETWEEN STATIONS */ 
select * from routes where tid=1001 and stopno between 2 and 4 order by stopno asc;

/* SEARCH SEAT AVAILABILITY OF TRAIN ON PARTICULAR DATE BETWEEN FROM and TO STATIONS */
select rid, seats from seats where seats.rid in (2,3) and startdate = (select startdate from seats where rid=2 and departuredate='2024-03-30');


            