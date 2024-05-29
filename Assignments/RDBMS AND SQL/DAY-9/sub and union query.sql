SELECT customer_id,customer_name FROM customers WHERE customer_id IN( SELECT customer_id  FROM orders GROUP BY customer_id HAVING AVG(order_id) > ( SELECT AVG(order_id) FROM orders) );
select customer_id,customer_name,email_address,city FROM customers
WHERE  city='hyderabad' UNION SELECT customer_id,customer_name,email_address,city FROM customers where customer_id NOT IN (SELECT customer_id FROM orders);
