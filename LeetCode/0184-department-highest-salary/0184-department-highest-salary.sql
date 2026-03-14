SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
WHERE (e.salary, e.departmentId) IN (SELECT 
    MAX(salary) as salary,
    e.departmentId
FROM Employee e
GROUP BY departmentId)