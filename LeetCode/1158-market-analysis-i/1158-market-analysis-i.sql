SELECT
    u.user_id AS buyer_id,
    u.join_date AS join_date,
    SUM(CASE WHEN YEAR(order_date) = 2019 THEN 1 ELSE 0 END) AS orders_in_2019
FROM Orders o
RIGHT JOIN Users u ON u.user_id = o.buyer_id
GROUP BY u.user_id