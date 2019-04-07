create database dbbookstore

use dbbookstore;

create table Author (
	authorID int primary key,
    firstName varchar(30),
    lastName varchar(30)
);