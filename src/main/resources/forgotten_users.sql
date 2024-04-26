SELECT alias
FROM Users
WHERE id NOT IN (
    SELECT DISTINCT user_id
    FROM Orders
    WHERE order_date >= NOW() - INTERVAL '6 months'
);
--Vitya