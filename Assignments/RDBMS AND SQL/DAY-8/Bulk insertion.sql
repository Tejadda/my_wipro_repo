use wipro_trainings;
-- Create Student1 table with a primary key
CREATE TABLE Student1 (
    StudentID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Age INT,
    GPA DECIMAL(3,2)
);

-- Insert some sample data
INSERT INTO Student1 (Name, Age, GPA) VALUES 
('Alice', 20, 3.5),
('Bob', 22, 3.2),
('Charlie', 21, 3.8);

-- Display the initial data
SELECT * FROM Student1;

-- Start transaction
START TRANSACTION;
set SQL_SAFE_UPDATES=0;
-- Update Bob's age
UPDATE Student1 SET Age = 23 WHERE Name = 'Bob';

-- Savepoint before further changes
SAVEPOINT before_update;

-- Display data after update
SELECT * FROM Student1;

-- Rollback to the savepoint
ROLLBACK TO SAVEPOINT before_update;

-- Display data after rollback
SELECT * FROM Student1;

-- Commit transaction
COMMIT;

-- Bulk Insertion
CREATE TEMPORARY TABLE Temp_Student1 (
    Name VARCHAR(100),
    Age INT,
    GPA DECIMAL(3,2)
);

-- Insert data into temporary table
INSERT INTO Temp_Student1 (Name, Age, GPA) VALUES 
('Dave', 25, 3.9),
('Eva', 22, 3.7);

-- Bulk insert into main table
INSERT INTO Student1 (Name, Age, GPA)
SELECT Name, Age, GPA FROM Temp_Student1;

-- Display data after bulk insertion
SELECT 
    *
FROM
    Student1;

