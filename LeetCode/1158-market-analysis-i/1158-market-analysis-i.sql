# Write your MySQL query statement below
WITH A AS(
    SELECT
        *
    FROM Orders o
    
)

SELECT
    user_id AS buyer_id,
    u.join_date,
    SUM(CASE WHEN YEAR(order_date) = '2019' THEN 1 ELSE 0 END)  AS orders_in_2019
FROM Users u
LEFT JOIN Orders o ON u.user_id = o.buyer_id
-- WHERE YEAR(order_date) = '2019' 
GROUP BY user_id