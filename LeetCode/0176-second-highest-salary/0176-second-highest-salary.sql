# Write your MySQL query statement below
SELECT
    (CASE WHEN COUNT(DISTINCT salary) > 0 THEN MAX(salary) END) AS SecondHighestSalary
FROM Employee
WHERE salary NOT IN (SELECT MAX(salary) FROM Employee)
ORDER BY salary DESC
