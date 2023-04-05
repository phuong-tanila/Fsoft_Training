create database CustomerManagement
use CustomerManagement

create table Customers(
	id int primary key,
	fullName varchar(50) not null,
	Address varchar(50) not null,
	phoneNumber varchar(10) not null,
	age int not null
)
