# Write your MySQL query statement below
SELECT
    project_id,
    AVG(experience_years) AS average_years
FROM Project p 
JOIN Employee e ON p.employee_id = e.employee_id
GROUP BY project_id