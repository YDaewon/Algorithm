# Write your MySQL query statement below
DELETE p FROM Person p
JOIN Person pp ON p.email = pp.email
WHERE p.id > pp.id;

