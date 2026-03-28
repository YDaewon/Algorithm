WITH A AS(
    SELECT
        r1.requester_id AS id,
        COUNT(r1.requester_id) AS num
    FROM RequestAccepted r1
    GROUP BY r1.requester_id
),
B AS(
    SELECT
        r1.accepter_id AS id,
        COUNT(r1.accepter_id) AS num
    FROM RequestAccepted r1
    GROUP BY r1.accepter_id
)

SELECT
    id,
    sum(num) AS num
FROM (SELECT * FROM A
UNION ALL
SELECT * FROM B) a
GROUP BY id
ORDER BY num DESC
LIMIT 1