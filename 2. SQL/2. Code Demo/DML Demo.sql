create database DML_Demo
use DML_Demo
drop database DML_Demo

create table Person(
	person_id int identity(1,1) primary key not null,
	first_name nvarchar(100) not null,
	last_name nvarchar(100) not null,
	dob date,
	full_name as (first_name + ' ' + last_name)
)

insert into Person values('abc', 'def', '12/12/2012') --mm/dd/yyyy
insert into Person values('abc', 'def', '12/13/2012')

select * from Person

update Person
set
first_name = 'nguyen', last_name = 'phuong' 
where
dob = '12/13/2012'

delete Person where first_name = 'abc'