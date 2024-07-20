SELECT usr.id, usr.alias
FROM Users usr
WHERE NOT EXISTS
(SELECT DISTINCT ord.user_id
FROM Orders ord
WHERE ord.order_date > NOW() - INTERVAL '12 months'
AND ord.user_id= usr.id)