-- Median Of Searches
SELECT ROUND(AVG(searches), 1) AS median
FROM (
    SELECT searches,
           ROW_NUMBER() OVER (ORDER BY searches) AS rn,
           COUNT(*) OVER () AS total
    FROM your_table
) t
WHERE rn IN ((total + 1) / 2, (total + 2) / 2);

/* 
identify any payments made at the same merchant with the same credit card for the same amount within 10 minutes of each other. 
Count such repeated payments.
*/
SELECT COUNT(*) AS payment_count
FROM transactions t1
JOIN transactions t2
    ON t1.merchant_id = t2.merchant_id
    AND t1.credit_card_id = t2.credit_card_id
    AND t1.amount = t2.amount
    AND t1.transaction_id < t2.transaction_id
    AND TIMESTAMPDIFF(
        MINUTE,
        t1.transaction_timestamp,
        t2.transaction_timestamp
    ) <= 10;

/*
Write a query to calculate the sum of odd-numbered and even-numbered measurements separately for a particular day 
and display the results in two different columns. Refer to the Example Output below for the desired format.
*/
WITH numbered AS (
    SELECT
        measurement_value,
        measurement_time::date AS measurement_day,
        ROW_NUMBER() OVER (
            PARTITION BY measurement_time::date
            ORDER BY measurement_time
        ) AS rn
    FROM measurements
)
SELECT
    measurement_day,
    SUM(measurement_value) FILTER (WHERE rn % 2 = 1) AS odd_sum,
    SUM(measurement_value) FILTER (WHERE rn % 2 = 0) AS even_sum
FROM numbered
GROUP BY measurement_day
ORDER BY measurement_day;
