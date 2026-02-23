# Write your MySQL query statement below
SELECT
    -- *
    s.id,
    CASE WHEN ss.id IS NULL THEN s.student ELSE ss.student END AS student
FROM Seat s
LEFT JOIN Seat ss ON (s.id % 2 = 1 AND ss.id = s.id + 1) OR (s.id % 2 = 0 AND ss.id = s.id -1)