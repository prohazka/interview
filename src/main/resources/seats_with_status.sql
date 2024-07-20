select s.row_num, s.seat_num, t.id is null as is_free from halls h
join seances sn on sn.hall_id=h.id
right join seats s on s.hall_id=h.id
left join tickets t on t.seance_id = sn.id and t.seat_id=s.id
where sn.id=3;