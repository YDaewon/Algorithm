# Write your MySQL query statement below
SELECT
    e.name
FROM Employee e
JOIN Employee ee ON e.id = ee.managerId
GROUP BY e.id
HAVING COUNT(*) >= 5