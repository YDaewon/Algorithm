SELECT 
    requester_id AS id,
    COUNT(*) AS num
FROM (
SELECT requester_id FROM RequestAccepted
UNION ALL
SELECT accepter_id FROM RequestAccepted
) a
GROUP BY id
ORDER BY num desc
LIMIT 1