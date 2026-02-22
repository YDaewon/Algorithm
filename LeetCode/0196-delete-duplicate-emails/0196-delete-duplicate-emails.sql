-- # Write your MySQL query statement below
DELETE p FROM Person p, Person pp 
WHERE p.email = pp.email AND p.id > pp.id