# Write your MySQL query statement below
WITH A AS(
    SELECT 
        player_id,
        MIN(event_date) AS event_date
    FROM Activity
    GROUP BY player_id 
)

SELECT
    ROUND(COUNT(*) / (SELECT COUNT(*) FROM A), 2) AS fraction
FROM Activity b
JOIN A ON b.event_date - INTERVAL 1 DAY = A.event_date
AND b.player_id = A.player_id
