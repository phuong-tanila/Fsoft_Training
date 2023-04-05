create database TrainingDB
use TrainingDB

drop database TrainingDB

/*create table Course(
	course_id varchar(5) primary key,
	subject_id varchar(4),
	course_Code varchar(10),
	course_title varchar(50),
	num_of_credits int
)

create table Enrollment(
	course_id varchar(5) not null,
	ssn int not null,
	date_registered date,
	grade char(1)
)
alter table Enrollment
add constraint FK_course_id_Enrollment_course_id_Course foreign key (course_id) references Course (course_id)
alter table Enrollment
add constraint FK_ssn_Enrollment_ssn_Student foreign key (ssn) references Student (ssn)
alter table Enrollment
add constraint PK_course_id_ssn primary key (course_id, ssn)

create table Student(
	ssn int primary key,
	first_name varchar(30),
	last_name varchar(30),
	birth_date date,
	street varchar(30),
	phone varchar(30),
	zip_code varchar(5)
)

select * from Student
insert into Student values
(1, 'Nguyen', 'Phuong', '2001/05/11', 'District 9', '0797575794', '70000'),
(2, 'Nguyen', 'Minh', '2001/05/20', 'District 1', '098772771', '70000'),
(3, 'Truong', 'Gia', '1999/10/21', 'District 3', '098005001', '70000'),
(4, 'Tran', 'Vinh', '2000/05/22', 'Binh Thanh', '098220221', '70000'),
(5, 'Nguyen', 'Duc', '2001/05/20', 'District 1', '098772771', '70000')
*/

CREATE TABLE course (
	course_id varchar(5) NOT NULL,
	subject_id varchar(4) NULL,
	course_code varchar(10) NULL,
	course_title varchar(50) NULL,
	num_of_credits int NULL,
	PRIMARY KEY (course_id)
);

select * from course

SELECT course_title, num_of_credits FROM Course ORDER BY num_of_credits DESC

select * from course where course_title LIKE '%academy'

/*
/***course 1***/
course_id = Fr05
subject_id = Ja05
course_code = Fresher
course_title = Fresher academy
num_of_credits = 5

/***course 2***/
course_id = In06
subject_id = Ja06
course_code = Intern
course_title = Intern academy
num_of_credits = 6

/***course 3***/
course_id = De07
subject_id = Ja07
course_code = Dev
course_title = Dev academy
num_of_credits = 7
*/