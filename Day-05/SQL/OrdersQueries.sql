/*
Tables
customer1(customer_id,cust_name,city,grade,salesman_id)
salesman(salesman_id,name,cit,commission)
orders1(ord_no,purch_amt,ord_date,customer_id,salesman_id)
*/


USE veeva;

-- Write a query to find the customer with customer_id 3004
-- who is handled by the salesman named 'Mc Lyon'.
SELECT *
FROM customer1
WHERE customer_id = 3004
  AND salesman_id IN (
      SELECT salesman_id
      FROM salesman
      WHERE name = 'Mc Lyon'
  );


-- Write a query to find the average grade for each city,
-- and display only those cities whose average grade is higher
-- than the average grade of customers in New York.
SELECT city, AVG(grade)
FROM customer1
GROUP BY city
HAVING AVG(grade) > (
    SELECT AVG(grade)
    FROM customer1
    WHERE city = 'New York'
);


-- Write a query to find the order number and customer ID
-- for orders placed on 2012-08-17.
SELECT o.ord_no, c.customer_id
FROM customer1 c
INNER JOIN orders1 o
    ON c.customer_id = o.customer_id
WHERE ord_date = '2012-08-17';


-- Write a query to find customers who have placed more than one order.
SELECT c.cust_name, c.customer_id, COUNT(*)
FROM orders1 o
INNER JOIN customer1 c
    ON o.customer_id = c.customer_id
GROUP BY customer_id
HAVING COUNT(*) > 1;


-- Write a query to find all orders with order amounts
-- that are above the average order amount for their customers.
SELECT ord_no, purch_amt, customer_id
FROM orders1 o
WHERE purch_amt > (
    SELECT AVG(purch_amt)
    FROM orders1
    WHERE customer_id = o.customer_id
);


-- Write a query to find the sums of the amounts from the orders table,
-- grouped by date, eliminating all those dates where the sum
-- was not at least 1000.00 above the maximum order amount for that date.
SELECT SUM(purch_amt)
FROM orders1
GROUP BY ord_date
HAVING SUM(purch_amt) > MAX(purch_amt) + 1000;


-- Write a query to extract the data from the customer table
-- if and only if one or more of the customers are located in London.
SELECT *
FROM customer1
WHERE EXISTS (
    SELECT 1
    FROM customer1
    WHERE city = 'London'
);


-- Write a query to find the salesmen who have multiple customers.
SELECT salesman_id
FROM orders1
GROUP BY salesman_id
HAVING COUNT(DISTINCT customer_id) > 1;


-- Write a query to find all the salesmen who worked for only one customer.
SELECT salesman_id
FROM orders1
GROUP BY salesman_id
HAVING COUNT(DISTINCT customer_id) = 1;


-- Write a query that extracts the rows of all salesmen
-- who have customers with more than one order.
SELECT salesman_id
FROM orders1
GROUP BY salesman_id, customer_id
HAVING COUNT(*) > 1;


-- Write a query to find all the salesmen with all information
-- who live in the city where any of their customers lives.
SELECT *
FROM salesman s
WHERE city = ANY (
    SELECT city
    FROM customer1 c
    WHERE c.salesman_id = s.salesman_id
);


-- Write a query to find all the salesmen for whom there are customers that follow them.
SELECT *
FROM salesman s
WHERE EXISTS (
    SELECT 1
    FROM customer1 c
    WHERE c.salesman_id = s.salesman_id
);


-- Write a query to display the salesmen whose names are
-- alphabetically lower than the names of all their customers.
SELECT *
FROM salesman s
WHERE s.name < ALL (
    SELECT name
    FROM customer1 c
    WHERE c.salesman_id = s.salesman_id
);


-- Write a query to display those customers whose grade is
-- higher than at least one customer belonging to a city alphabetically lower than New York.
SELECT *
FROM customer1
WHERE grade > ANY (
    SELECT grade
    FROM customer1
    WHERE city < 'New York'
);


-- Write a query to display all the orders that had amounts
-- greater than at least one of the orders on September 10th, 2012.
SELECT *
FROM orders1
WHERE purch_amt > ANY (
    SELECT purch_amt
    FROM orders1
    WHERE ord_date = '2012-09-10'
);


-- Write a query to find all orders with an amount smaller
-- than any amount for a customer in London.
SELECT *
FROM orders1
WHERE purch_amt < ANY (
    SELECT o.purch_amt
    FROM orders1 o
    INNER JOIN customer1 c
        ON c.customer_id = o.customer_id
    WHERE c.city = 'London'
);


-- Write a query to display all orders with an amount smaller
-- than the maximum amount for a customer in London.
SELECT *
FROM orders1
WHERE purch_amt < (
    SELECT MAX(purch_amt)
    FROM orders1 o
    INNER JOIN customer1 c
        ON c.customer_id = o.customer_id
    WHERE c.city = 'London'
);


-- Write a query to display only those customers whose grades are
-- higher than every customer in New York.
SELECT *
FROM customer1
WHERE grade > ALL (
    SELECT grade
    FROM customer1
    WHERE city = 'New York'
);


-- Write a query to find all those customers whose grade
-- is not the same as the grade of any customer who belongs to London.
SELECT *
FROM customer1
WHERE grade NOT IN (
    SELECT grade
    FROM customer1
    WHERE city = 'London'
);


-- Write a query to find all those customers whose grade
-- is not the same as the grade of any customer who belongs to Paris.
SELECT *
FROM customer1
WHERE grade NOT IN (
    SELECT grade
    FROM customer1
    WHERE city = 'Paris'
);


-- Write a query to find all those customers who hold a different grade
-- than any customer of the city Dallas.
SELECT *
FROM customer1
WHERE grade NOT IN (
    SELECT grade
    FROM customer1
    WHERE city = 'Dallas'
);
