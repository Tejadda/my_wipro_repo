use wipro_trainings;
CREATE TABLE customers(
customer_id INT PRIMARY KEY,
customer_name VARCHAR(100),
email_address VARCHAR(100),
city VARCHAR(100));
INSERT INTO customers (customer_id, customer_name, email_address,city)VALUES 
(1,'Teja','teja@gmail.com','vuyyuru'),
(2,'Tejaswi','tejaswi@gmail.com','banglore'),
(3,'Dda','dda@gmail.com','chinnaogirala'),
(4,'chinni','chinni@gmail.com','banglore'),
(5,'nani','nani@gmail.com','hyderabad'),
(6,'bujji','bujji@gmail.com','vizag'),
(7,'kanna','kanna@gmail.com','chennai'),
(8,'Mummy','mummy@gmail.com','hyderabad'),
(9,'Ammu','ammu@gmail.com','vizag'),
(10,'Amma','amma@gmail.com','chennai');

SELECT * FROM customers;
SELECT customer_name,email_address FROM customers WHERE  city='hyderabad';