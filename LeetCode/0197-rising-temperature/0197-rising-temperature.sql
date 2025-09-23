# Write your MySQL query statement below
SELECT w.id AS Id FROM Weather w
JOIN Weather ww ON w.recordDate = ww.recordDate + 1
WHERE w.temperature > ww.temperature;