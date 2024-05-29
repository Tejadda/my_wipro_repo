/*use tejadda;*/
CREATE USER 'new_user'@'localhost' IDENTIFIED BY 'password123';
GRANT SELECT, INSERT, UPDATE on example_db.* TO 'new_user'@'localhost';
REVOKE UPDATE ON example_db.* FROM 'new_user'@'localhost';
DROP USER 'new_user'@'localhost';