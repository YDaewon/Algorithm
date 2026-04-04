SELECT
    c1.visited_on,
    SUM(c2.amount) AS amount,
    ROUND(AVG(c2.amount), 2) AS average_amount
FROM (SELECT visited_on, SUM(amount) AS amount FROM Customer GROUP BY visited_on) c1
JOIN (SELECT visited_on, SUM(amount) AS amount FROM Customer GROUP BY visited_on) c2 
ON DATEDIFF(c1.visited_on, c2.visited_on) >= 0 AND DATEDIFF(c1.visited_on, c2.visited_on) <= 6
GROUP BY c1.visited_on
HAVING COUNT(c2.amount) = 7