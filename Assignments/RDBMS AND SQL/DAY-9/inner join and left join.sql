CREATE TABLE  orders(
order_id INT PRIMARY KEY,
customer_id INT,
order_date DATE,
foreign key (customer_id) references customers(customer_id));
select c.customer_id, c.customer_name, c.email_address,c.city,o.order_id,o.order_date
from customers c 
LEFT JOIN orders o ON c.customer_id=o.customer_id
where c.city IN ('hyderabad','banglore','chennai') OR o.customer_id 
IS NULL;