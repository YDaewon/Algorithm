CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT (CASE WHEN COUNT(salary) >= N AND N > 0 THEN MIN(salary) END) FROM 
      (SELECT
        DISTINCT salary
      FROM Employee
      ORDER BY salary DESC
      LIMIT N) AS t
  );
END