CREATE TABLE customers (
    cust_id INT PRIMARY KEY,
    cust_name VARCHAR(100),
    region VARCHAR(50)
);

CREATE TABLE product (
    product_name VARCHAR(100) PRIMARY KEY,
    price DECIMAL(10,2)
);

CREATE TABLE purchases (
    purchase_id INT PRIMARY KEY,
    cust_id INT,
    product_name VARCHAR(100),
    FOREIGN KEY (cust_id) REFERENCES customers(cust_id),
    FOREIGN KEY (product_name) REFERENCES product(product_name)
);

INSERT INTO customers VALUES
(1, 'Rahul', 'North'),
(2, 'Priya', 'South'),
(3, 'Arjun', 'North'),
(4, 'Sneha', 'East'),
(5, 'Kiran', 'West'),
(6, 'Anjali', 'North'),
(7, 'Ravi', 'South'),
(8, 'Neha', 'North');

INSERT INTO product VALUES
('Product A', 5000),
('Product B', 15000),
('Product C', 25000),
('Product D', 18000),
('Product E', 10000),
('Product F', 22000);

CREATE TABLE purchases (
    purchase_id INT PRIMARY KEY,
    cust_id INT,
    product_name VARCHAR(100),
    FOREIGN KEY (cust_id) REFERENCES customers(cust_id),
    FOREIGN KEY (product_name) REFERENCES product(product_name)
);

INSERT INTO purchases (purchase_id, cust_id, product_name) VALUES
(1, 1, 'Product B'),
(2, 1, 'Product A'),
(3, 2, 'Product C'),
(4, 3, 'Product B'),
(5, 3, 'Product D'),
(6, 4, 'Product E'),
(7, 5, 'Product B'),
(8, 6, 'Product F'),
(9, 6, 'Product B'),
(10, 7, 'Product D'),
(11, 8, 'Product B');

insert into product values
('Product G', 120000);

insert into purchases values(12,2,'Product G');

-- Filter the customers who have purchased Product A or Product B
select c.cust_id,c.cust_name from purchases p inner join customers c on c.cust_id=p.cust_id where p.product_name in ('Product B','Product A') and region in ('west','north');

-- Filter customers who have purchased product worth 1,00,000 to 2,00,000
select c.cust_id,c.cust_name from purchases p1 inner join customers c on c.cust_id=p1.cust_id inner join product p2 on p1.product_name=p2.product_name where p2.price between 100000 and 200000;
