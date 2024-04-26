SELECT h.id, h.title
FROM Halls h
WHERE h.id = (
    SELECT hall_id
    FROM (
        SELECT hall_id, COUNT(*) AS cnt
        FROM Seats
        GROUP BY hall_id
        ORDER BY cnt DESC
        LIMIT 1
    ) AS max_seat_id
);
--2 green