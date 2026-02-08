# Write your MySQL query statement below
WITH a AS(
    SELECT
        user_id,
        reaction, 
        COUNT(*) AS count
    FROM reactions
    GROUP BY user_id, reaction
),
b AS(
    SELECT 
        user_id,
        MAX(count) AS max,
        SUM(count) AS total
    FROM a
    GROUP BY user_id
)

SELECT 
    a.user_id,
    reaction AS dominant_reaction,
    ROUND(max / total,2) AS reaction_ratio
FROM a
JOIN b ON a.user_id = b.user_id
WHERE a.count = b.max
AND b.total >= 5
AND ROUND(max / total, 2) > 0.6
ORDER BY 3 desc, 1 asc