create database dbbookstore

use dbbookstore;

drop table Author
create table Author (
	authorID int primary key auto_increment,
    firstName varchar(30),
    lastName varchar(30)
);

INSERT INTO Author(firstName,lastName) VALUES('Ismajl','Kadare');

drop table if exists Book
create table Book (
 bookID int primary key auto_increment,
 title varchar(40),
 author varchar(60),
 genre varchar(20),
 publication_year int,
 price real
 );
 
INSERT INTO Book(title,author,genre,publication_year,price)  VALUES('Gjenerali i ushtrise se vdekur','Ismajl Kadare','Roman',2004,3.5);
INSERT INTO Book(title,author,genre,publication_year,price)  VALUES('Princesha Argjiro','Ismajl Kadare','Roman',1957,3.7);
INSERT INTO Book(title,author,genre,publication_year,price)  VALUES('Ca pika shiu rane mbi qele','Ismajl Kadare','Poezi',2004,3.0);
INSERT INTO Book(title,author,genre,publication_year,price)  VALUES('Pa forme eshte qielli','Ismajl Kadare','Poezi',2005,3.7);
INSERT INTO Book(title,author,genre,publication_year,price)  VALUES('Vepra poetike ne nje vellim','Ismajl Kadare','Poezi',2018,3.9);


select * from Book

create table Users(
	uID integer primary key auto_increment,
    firstName varchar(30) not null,
    lastName varchar(30),
    gender char(1) not null,
    username varchar(30) unique,
    password varchar(30) not null,
    telephone varchar(15) not null,
    address varchar(30) not null,
    city varchar(30) not null);
    
drop table if exists Sales
create table Sales(
	sID int primary key auto_increment,
    bookID int,
    upload_date date,
    foreign key(bookID) references Book(bookID) on delete cascade);
 
 drop table if exists Purchases
create table Purchases(
	pID int primary key auto_increment,
    bookID int,
    purchase_date date,
    foreign key(bookID) references Book(bookID) on delete cascade);
    
    
    select * from users
