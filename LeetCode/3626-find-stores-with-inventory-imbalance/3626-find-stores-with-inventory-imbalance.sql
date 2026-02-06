WITH ranked AS (
    SELECT
        store_id,
        product_name,
        quantity,
        price,
        RANK() OVER (PARTITION BY store_id ORDER BY price DESC, quantity DESC) AS high,
        RANK() OVER (PARTITION BY store_id ORDER BY price ASC, quantity DESC) AS low
    FROM inventory
),
expensive AS(
    SELECT
        store_id,
        product_name,
        quantity
    FROM ranked
    WHERE high = 1
),
cheap AS(
    SELECT
        store_id,
        product_name,
        quantity
    FROM ranked
    WHERE low = 1
)
SELECT 
    s.store_id,
    s.store_name,
    s.location,
    e.product_name as most_exp_product,
    c.product_name as cheapest_product,
    ROUND(c.quantity / e.quantity, 2) as imbalance_ratio
FROM stores s
JOIN expensive e ON s.store_id = e.store_id
JOIN cheap c ON s.store_id = c.store_id
WHERE c.quantity > e.quantity
AND s.store_id IN (SELECT store_id FROM inventory GROUP BY store_id HAVING COUNT(*) >= 3)
ORDER BY 6 desc, 2 asc
