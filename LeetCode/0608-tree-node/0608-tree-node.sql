SELECT
    id,
    CASE 
    WHEN p_id IS null THEN 'Root' 
    WHEN id IN (SELECT p_id FROM Tree WHERE p_id IS NOT NULL) THEN 'Inner' ELSE 'Leaf' END
    AS type
FROM Tree