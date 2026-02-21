-- # Write your MySQL query statement below
SELECT 
    ww.id
FROM Weather w
JOIN Weather ww ON w.recordDate + INTERVAL 1 DAY = ww.recordDate
WHERE w.temperature < ww.temperature