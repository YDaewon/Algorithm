# Write your MySQL query statement below
SELECT
    e.name AS Employee
FROM Employee e
JOIN Employee ee ON ee.id = e.managerId
WHERE e.salary > ee.salary