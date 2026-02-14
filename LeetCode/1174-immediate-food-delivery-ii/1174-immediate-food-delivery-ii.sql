# Write your MySQL query statement below
WITH a AS(
    SELECT
        customer_id,
        MIN(order_date) AS mini
    FROM Delivery
    GROUP BY customer_id
)

SELECT 
    ROUND(
        SUM(CASE WHEN d.order_date = d.customer_pref_delivery_date THEN 1 ELSE 0 END) / 
        COUNT(*), 5
    ) * 100 AS immediate_percentage
FROM a
JOIN Delivery d ON a.customer_id = d.customer_id
WHERE a.mini = d.order_date