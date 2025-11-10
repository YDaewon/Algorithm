# Write your MySQL query statement below
SELECT
  employee_id,
  CASE WHEN name IN (SELECT name FROM Employees WHERE name LIKE "M%") OR employee_id % 2 = 0 THEN 0 ELSE salary END
bonus
FROM Employees
ORDER BY employee_id ASC