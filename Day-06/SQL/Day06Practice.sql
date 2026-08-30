-- Find missing number in a sequence when the squence starts from 1
SELECT 
    MAX(num) * (MAX(num) + 1) / 2 - SUM(num) AS missing_number
FROM numbers;

-- Find missing number in a sequence when the squence starts from any number
SELECT num + 1 AS missing_number
FROM (
    SELECT num,
           LEAD(num) OVER (ORDER BY num) AS next_num
    FROM numbers
) t
WHERE next_num - num > 1;

-- Find users who logged in on 3 consecutive calendar days
SELECT DISTINCT user_name
FROM (
    SELECT
        user_name,
        login_date,
        LAG(login_date, 1) OVER (
            PARTITION BY user_name
            ORDER BY login_date
        ) AS prev_date,
        LAG(login_date, 2) OVER (
            PARTITION BY user_name
            ORDER BY login_date
        ) AS prev_prev_date
    FROM login_details
) t
WHERE DATEDIFF(login_date, prev_date) = 1
  AND DATEDIFF(prev_date, prev_prev_date) = 1;

-- Find 3-month moving average of sales
SELECT
    month,
    year,
    total_sales,
    AVG(total_sales) OVER (
        ORDER BY year, month
        ROWS BETWEEN 2 PRECEDING AND CURRENT ROW
    ) AS moving_avg_3_month
FROM sales
ORDER BY year, month;
