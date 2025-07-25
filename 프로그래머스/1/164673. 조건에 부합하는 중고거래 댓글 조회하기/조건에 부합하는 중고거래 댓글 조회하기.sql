-- 코드를 입력하세요
SELECT 
b.TITLE, b.BOARD_ID, REPLY_ID, 
r.WRITER_ID, r.CONTENTS, DATE_FORMAT(r.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
# FROM USED_GOODS_REPLY r JOIN USED_GOODS_BOARD b ON r.BOARD_ID = b.BOARD_ID
FROM USED_GOODS_REPLY r, USED_GOODS_BOARD b 
WHERE b.CREATED_DATE LIKE '2022-10%'
AND r.BOARD_ID = b.BOARD_ID
ORDER BY r.CREATED_DATE ASC, b.TITLE ASC
