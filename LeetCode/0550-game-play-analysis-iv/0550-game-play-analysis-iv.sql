WITH a AS(
SELECT
    player_id,
    MIN(event_date) AS event_date
FROM Activity
GROUP BY player_id
)


SELECT
    ROUND(COUNT(DISTINCT b.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 2) AS fraction
FROM Activity b
JOIN a ON b.event_date = a.event_date + INTERVAL 1 DAY
AND a.player_id = b.player_id
