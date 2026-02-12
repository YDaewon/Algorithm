# Write your MySQL query statement below
with t as(
    SELECT 
        stock_name,
        SUM(CASE WHEN operation = 'Buy' THEN price ELSE 0 END) AS buy,
        SUM(CASE WHEN operation = 'Sell' THEN price ELSE 0 END) AS sell
    FROM Stocks
    GROUP BY stock_name
)

SELECT 
    stock_name,
    (sell - buy) as capital_gain_loss
FROM t