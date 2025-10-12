# Write your MySQL query statement below
SELECT 
    fa.machine_id,
    ROUND(AVG(sa.timestamp - fa.timestamp), 3) AS processing_time 
FROM Activity fa
JOIN Activity sa 
    ON fa.machine_id = sa.machine_id
    AND fa.process_id = sa.process_id 
    AND fa.activity_type = 'start' 
    AND sa.activity_type = 'end'
GROUP BY fa.machine_id


-- 