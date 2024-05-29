/*use tejadda;
CREATE TABLE employees(
id INT PRIMARY KEY,
name VARCHAR(100),
department VARCHAR(50),
salary DECIMAL(10,2)
);

INSERT INTO employees(id,name,department,salary)VALUES
(1,'Alice','HR',60000),
(2,'Bob','IT',70000),
(3,'Charlie','Finance',80000),
(4,'David','IT',90000),
(5,'Eve','HR',65000);
CREATE INDEX idx_department ON employees(department);
EXPLAIN SELECT * FROM employees WHERE department='IT';
DROP INDEX idx_department ON employees;*/
EXPLAIN SELECT * FROM employees WHERE department='IT';