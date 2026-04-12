WITH A AS(
    SELECT
        requester_id AS id,
        COUNT(*) AS num
    FROM RequestAccepted
    GROUP BY requester_id
),
B AS(
    SELECT
        accepter_id AS id,
        COUNT(*) AS num
    FROM RequestAccepted
    GROUP BY accepter_id 
)

SELECT 
    id,
    SUM(num) AS num
FROM (
    SELECT * FROM A
    UNION ALL
    SELECT * FROM B
) x
GROUP BY id
ORDER BY num DESC
LIMIT 1
