# Write your MySQL query statement below
SELECT
    e.employee_id,
    e.name,
    COUNT(*) AS reports_count,
    ROUND(AVG(ee.age), 0) AS average_age
FROM Employees e
JOIN Employees ee ON e.employee_id = ee.reports_to
GROUP BY ee.reports_to
ORDER BY employee_id ASC