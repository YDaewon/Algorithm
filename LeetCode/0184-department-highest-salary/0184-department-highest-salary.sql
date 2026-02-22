# Write your MySQL query statement below
-- WITH a AS(
--     SELECT
--         e.departmentId,
--         MAX(e.salary) AS Salary
--     FROM Employee e
--     GROUP BY departmentId 
-- )

SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE (e.departmentId, e.salary) IN (SELECT
        e.departmentId,
        MAX(e.salary) AS Salary
    FROM Employee e
    GROUP BY departmentId )