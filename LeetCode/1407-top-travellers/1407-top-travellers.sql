# Write your MySQL query statement below
SELECT 
name,
(CASE WHEN SUM(distance) IS NOT null THEN SUM(distance) ELSE 0 END) AS travelled_distance FROM Users u
LEFT JOIN Rides r ON u.id = r.user_id
GROUP BY r.user_id
ORDER BY travelled_distance DESC, name ASC