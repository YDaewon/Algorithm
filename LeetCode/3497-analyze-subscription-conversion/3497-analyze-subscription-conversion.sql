# Write your MySQL query statement below
WITH a AS(
    SELECT
        user_id,
        SUM(CASE WHEN activity_type = 'free_trial' THEN 1 ELSE 0 END) AS free_cnt,
        SUM(CASE WHEN activity_type = 'paid' THEN 1 ELSE 0 END) AS paid_cnt,
        SUM(CASE WHEN activity_type = 'free_trial' THEN activity_duration ELSE 0 END) AS free_duration,
        SUM(CASE WHEN activity_type = 'paid' THEN activity_duration ELSE 0 END) AS paid_duration
    FROM UserActivity
    GROUP BY user_id
)

SELECT
    user_id,
    ROUND(free_duration / free_cnt, 2) AS trial_avg_duration,
    ROUND(paid_duration / paid_cnt, 2) AS paid_avg_duration
FROM a
WHERE paid_duration > 0
ORDER BY 1 ASC