WITH r AS(
    SELECT
    requester_id AS id,
    COUNT(accepter_id) AS cnt
    FROM RequestAccepted
    GROUP BY requester_id
),

a AS(
    SELECT
    accepter_id AS id,
    COUNT(requester_id) AS cnt
    FROM RequestAccepted
    GROUP BY accepter_id
),

u AS(
    SELECT * FROM a
    UNION ALL
    SELECT * FROM r
)

SELECT 
    id,
    SUM(cnt) AS num
FROM u
GROUP BY ID
ORDER BY num desc
LIMIT 1
