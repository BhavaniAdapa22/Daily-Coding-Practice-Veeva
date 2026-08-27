-- Calculate Average sales monthly revenue for each product

SELECT
    product_id,
    AVG(monthly_revenue) AS avg_monthly_revenue
FROM (
    SELECT
        product_id,
        YEAR(sales_date) AS year,
        MONTH(sales_date) AS month,
        SUM(sale_price) AS monthly_revenue
    FROM sales
    GROUP BY
        product_id,
        YEAR(sales_date),
        MONTH(sales_date)
) t
GROUP BY product_id;
