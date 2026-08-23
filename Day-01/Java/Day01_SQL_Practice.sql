
-- Database
use veeva;

-- Query to find total amount of order per day
select order_date,sum(order_amount) from orders group by order_date;

-- Total orderss per each month
select month(order_date) as month,sum(order_amount) from orders group by month(order_date);

-- Customer Table
create table customer(cust_id int primary key,name varchar(50),city varchar(50));

-- order1 table
create table order1(ord_id int primary key,ord_date date,order_amount int,cust_id int, CONSTRAINT fk_orders_user 
    FOREIGN KEY (cust_id) REFERENCES customer(cust_id));

-- Total Number of orders placed by each customer excluding orders place in june
select cust_id,count(*) from order1 where month(ord_date) <> 6 group by cust_id ;

-- Find customersd who have placed highest order value
with ord as(select cust_id,sum(order_amount) as total from order1 group by cust_id) select cust_id,total from ord order by total desc limit 1;

-- List all orders placed on 2023-07-04 , 2027-07-06
select * from order1 where ord_date in ('2023-07-04','2027-07-06');

--  Find Average order value for each city
select avg(o.order_amount),c.city from customer c inner join order1 o on c.cust_id=o.cust_id group by c.city;

-- Find the month with highest order value
with ord as(select month(ord_date) as month,sum(order_amount) as total from order1 group by month(ord_date)) select month,total from ord order by total desc limit 1;

-- Top 2 customers with most orders in last 30 days
SELECT cust_id, COUNT(*) AS order_count FROM order1 WHERE ord_date >= CURRENT_DATE - INTERVAL 30 DAY GROUP BY cust_id ORDER BY order_count DESC LIMIT 2;

-- Customers who have not placed any orders
SELECT c.cust_id, c.name, c.city FROM customer c LEFT JOIN order1 o ON c.cust_id = o.cust_id WHERE o.cust_id IS NULL;
