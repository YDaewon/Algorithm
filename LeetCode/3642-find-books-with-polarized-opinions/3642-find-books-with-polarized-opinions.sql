# Write your MySQL query statement below
SELECT 
    b.book_id,
    b.title, 
    b.author, 
    b.genre, 
    b.pages, 
    (hl2.highest - hl2.lowest) as rating_spread, 
    ROUND((hl.high_sessions + hl.low_sessions) / hl2.cnt, 2) as polarization_score 
FROM books b
JOIN
(SELECT 
    book_id, 
    SUM(CASE WHEN session_rating >= 4 THEN 1 ELSE 0 END) as high_sessions,
    SUM(CASE WHEN session_rating <= 2 THEN 1 ELSE 0 END) as low_sessions 
FROM reading_sessions
GROUP BY book_id
HAVING high_sessions > 0 AND low_sessions > 0) hl ON b.book_id = hl.book_id
JOIN
(SELECT book_id, COUNT(session_rating) as cnt, MAX(session_rating) as highest, MIN(session_rating) as lowest FROM reading_sessions
GROUP BY book_id) hl2 ON b.book_id = hl2.book_id
WHERE (hl.high_sessions + hl.low_sessions) / hl2.cnt >= 0.6
AND hl2.cnt >= 5
ORDER BY 7 desc, 2 desc

-- HIGH AND LOW
-- SELECT 
--     book_id, 
--     SUM(CASE WHEN session_rating >= 4 THEN 1 ELSE 0 END) as high_sessions,
--     SUM(CASE WHEN session_rating <= 2 THEN 1 ELSE 0 END) as low_sessions 
-- FROM reading_sessions
-- GROUP BY book_id
-- HAVING high_sessions > 0 AND low_sessions > 0 

-- highest, lowest
-- SELECT book_id, COUNT(session_rating) as cnt, MAX(session_rating) as highest, MIN(session_rating) as lowest FROM reading_sessions
-- GROUP BY book_id

