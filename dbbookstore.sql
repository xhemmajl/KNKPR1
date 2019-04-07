create database dbbookstore

use dbbookstore;

create table Author (
	authorID int primary key,
    firstName varchar(30),
    lastName varchar(30)
);
create table Book (
 bookID int primary key,
 authorID int,
 title varchar(40),
 ISBN int,
 genre varchar(20),
 publication_year char(5),
 price varchar(6),
 foreign key(authorID) references Author(authorID)
 );
 

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
    

create table Sales(
	sID int primary key auto_increment,
    bookID int,
    upload_date date,
    foreign key(bookID) references Book(bookID) on delete cascade);
 
create table Purchases(
	pID int primary key auto_increment,
    bookID int,
    purchase_date date,
    foreign key(bookID) references Book(bookID) on delete cascade);
