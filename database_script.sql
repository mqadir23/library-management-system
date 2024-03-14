1.create database 1ms;
2.create table users(id int PRIMARY KEY AUTO_INCREMENT NOT null, name varchar(50), password varchar(50), email varchar(100), contact varchar(20));
3.create table books_details(book_id int PRIMARY key not null, book_name varchar(100), author_name varchar(200), quantity int);
4.create table student_details(student_id int PRIMARY KEY NOT null, student_name varchar(30), course_name varchar(50), branch varchar(50));
5.create table issue_book_details(id int PRIMARY KEY not null AUTO_INCREMENT, book_id int, book_name varchar(150), student_id int, student_name varchar(50), issue_date date, due_date date, status varchar(20));
