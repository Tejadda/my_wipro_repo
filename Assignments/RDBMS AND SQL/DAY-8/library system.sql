/*CREATE DATABASE Library;

USE Library;

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publication_year INT NOT NULL,
    genre VARCHAR(50),
    ISBN VARCHAR(13) UNIQUE
);
CREATE TABLE Members (
    member_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(15)
);
CREATE TABLE Loans (
    loan_id INT PRIMARY KEY,
    book_id INT,
    member_id INT,
    loan_date DATE NOT NULL,
    return_date DATE,
    returned BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_books FOREIGN KEY (book_id) REFERENCES Books(book_id),
    CONSTRAINT fk_members FOREIGN KEY (member_id) REFERENCES Members(member_id)
);*/