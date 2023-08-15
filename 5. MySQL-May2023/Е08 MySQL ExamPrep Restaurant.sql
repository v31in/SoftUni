-- Section 1: Data Definition Language (DDL)

CREATE DATABASE restaurants;
USE restaurants;

CREATE TABLE products(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    type VARCHAR(30) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

CREATE TABLE clients(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    card VARCHAR(50),
    review TEXT
);

CREATE TABLE tables(
    id INT PRIMARY KEY AUTO_INCREMENT,
    floor INT NOT NULL,
    reserved TINYINT(1),
    capacity INT NOT NULL
);

CREATE TABLE waiters(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    salary DECIMAL(10, 2)
);

CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    table_id INT NOT NULL,
    waiter_id INT NOT NULL,
    order_time TIME NOT NULL,
    payed_status TINYINT(1),
    CONSTRAINT fk_table_id FOREIGN KEY (table_id) REFERENCES tables(id),
    CONSTRAINT fk_waiter_id FOREIGN KEY (waiter_id) REFERENCES waiters(id)
);

CREATE TABLE orders_products(
    order_id INT,
    product_id INT,
    CONSTRAINT fk_order_id_products FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT fk_product_id_products FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE orders_clients(
    order_id INT,
    client_id INT,
    CONSTRAINT fk_order_id_clients FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT fk_product_id_clients FOREIGN KEY (client_id) REFERENCES clients(id)
);

-- Section 2: Data Manipulation Language (DML)

-- Insert

INSERT INTO products (name, type, price)
SELECT CONCAT_WS(' ', last_name, 'specialty'),
       'Cocktail',
       CEIL(salary * 0.01)
FROM waiters
WHERE id > 6;

-- Update

UPDATE orders
SET table_id = table_id - 1
WHERE id >= 12 AND id <= 23;

-- Delete

DELETE FROM waiters
WHERE id NOT IN (
    SELECT DISTINCT waiter_id FROM orders
);

-- Clients

SELECT id,
       first_name,
       last_name,
       birthdate,
       card,
       review
FROM clients
ORDER BY birthdate DESC, id DESC;

-- Birthdate

SELECT first_name,
       last_name,
       birthdate,
       review
FROM clients AS c
WHERE c.card IS NULL AND YEAR(c.birthdate) BETWEEN '1978' AND '1993'
ORDER BY last_name DESC, id
LIMIT 5;

-- Accounts

SELECT CONCAT(last_name, first_name, LENGTH(first_name), 'Restaurant') AS 'username',
       CONCAT(REVERSE(SUBSTR(email, 2, 12))) AS 'passwords'
FROM waiters
WHERE salary IS NOT NULL
ORDER BY passwords DESC;

-- Top from menu

SELECT p.id,
       p.name,
       COUNT(op.product_id) AS 'count'
FROM products AS p
JOIN orders_products AS op
    ON p.id = op.product_id
GROUP BY p.id, p.name
HAVING count >= 5
ORDER BY count DESC,
         p.name;
         
-- Availability

SELECT t.id AS table_id,
       t.capacity,
       COUNT(oc.client_id) AS count_clients,
       CASE
           WHEN COUNT(oc.client_id) = 0 THEN 'Free seats'
           WHEN COUNT(oc.client_id) < t.capacity THEN 'Free seats'
           WHEN COUNT(oc.client_id) = t.capacity THEN 'Full'
           ELSE 'Extra seats'
       END AS availability
FROM tables AS t
LEFT JOIN orders AS o
    ON t.id = o.table_id
LEFT JOIN orders_clients AS oc
    ON o.id = oc.order_id
WHERE t.floor = 1
GROUP BY t.id,
         t.capacity
HAVING COUNT(oc.client_id) > 0
ORDER BY t.id DESC;

-- Extract bill

CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(19,2)
DETERMINISTIC
DELIMITER //
BEGIN
    DECLARE total_bill DECIMAL(19,2);
    SELECT SUM(p.price)
    INTO total_bill
    FROM orders
    JOIN orders_clients AS oc
        ON orders.id = oc.order_id
    JOIN clients AS c
        ON c.id = oc.client_id
    JOIN orders_products AS op
        ON orders.id = op.order_id
    JOIN products AS p
        ON p.id = op.product_id
    WHERE CONCAT_WS(' ', first_name, last_name) = full_name;
    RETURN total_bill;
END//

SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';

-- Happy hour

CREATE PROCEDURE udp_happy_hour(type_input VARCHAR(50))
BEGIN
    UPDATE products
        SET price = price - (price * 0.20)
    WHERE price >= 10.00 AND type = type_input;
END;
