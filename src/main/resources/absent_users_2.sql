select u.id from Users u
JOIN Orders o ON u.id = o.user_id
GROUP BY u.id
HAVING MAX(order_date) < NOW() - INTERVAL '12 months'