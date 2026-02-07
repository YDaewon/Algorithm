# Write your MySQL query statement below
WITH count AS (
    SELECT 
        customer_id,
        SUM(CASE WHEN transaction_type = 'purchase' THEN 1 ELSE 0 END) AS parchase_count,
        SUM(CASE WHEN transaction_type = 'refund' THEN 1 ELSE 0 END) AS refund_count,
        COUNT(*) AS transaction_count,
        DATEDIFF(MAX(transaction_date), MIN(transaction_date)) AS active_period
    FROM customer_transactions
    GROUP BY customer_id
)


SELECT customer_id FROM count
WHERE parchase_count >= 3
AND ROUND(refund_count / transaction_count, 2) < 0.2
AND active_period >= 30
ORDER BY 1 ASC