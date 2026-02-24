SELECT
    s.id,
    IFNULL(ss.student, s.student) AS student
FROM Seat s
LEFT JOIN Seat ss ON (s.id % 2 = 1 AND s.id +1 = ss.id) OR (s.id % 2 = 0 AND s.id - 1 = ss.id)
ORDER BY 1 ASC