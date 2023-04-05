create database EMS
use EMS

-- Create table Employee, Status = 1: are working
CREATE TABLE [dbo].[Employee](
	[EmpNo] [int] NOT NULL
,	[EmpName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[BirthDay] [datetime] NOT NULL
,	[DeptNo] [int] NOT NULL
, 	[MgrNo] [int]
,	[StartDate] [datetime] NOT NULL
,	[Salary] [money] NOT NULL
,	[Status] [int] NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
,	[Level] [int] NOT NULL
) ON [PRIMARY]

GO

ALTER TABLE Employee 
ADD CONSTRAINT PK_Emp PRIMARY KEY (EmpNo)
GO

ALTER TABLE [dbo].[Employee]  
ADD  CONSTRAINT [chk_Level] 
	CHECK  (([Level]=(7) OR [Level]=(6) OR [Level]=(5) OR [Level]=(4) OR [Level]=(3) OR [Level]=(2) OR [Level]=(1)))
GO
ALTER TABLE [dbo].[Employee]  
ADD  CONSTRAINT [chk_Status] 
	CHECK  (([Status]=(2) OR [Status]=(1) OR [Status]=(0)))

GO
ALTER TABLE [dbo].[Employee]
ADD Email NCHAR(30) 
GO

ALTER TABLE [dbo].[Employee]
ADD CONSTRAINT chk_Email CHECK (Email IS NOT NULL)
GO

ALTER TABLE [dbo].[Employee] 
ADD CONSTRAINT chk_Email1 UNIQUE(Email)

GO
ALTER TABLE Employee
ADD CONSTRAINT DF_EmpNo DEFAULT 0 FOR EmpNo

GO
ALTER TABLE Employee
ADD CONSTRAINT DF_Status DEFAULT 0 FOR Status

GO
CREATE TABLE [dbo].[Skill](
	[SkillNo] [int] IDENTITY(1,1) NOT NULL
,	[SkillName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO
ALTER TABLE Skill
ADD CONSTRAINT PK_Skill PRIMARY KEY (SkillNo)

GO
CREATE TABLE [dbo].[Department](
	[DeptNo] [int] IDENTITY(1,1) NOT NULL
,	[DeptName] [nchar](30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
,	[Note] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO
ALTER TABLE Department
ADD CONSTRAINT PK_Dept PRIMARY KEY (DeptNo)

GO
CREATE TABLE [dbo].[Emp_Skill](
	[SkillNo] [int] NOT NULL
,	[EmpNo] [int] NOT NULL
,	[SkillLevel] [int] NOT NULL
,	[RegDate] [datetime] NOT NULL
,	[Description] [nchar](100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT PK_Emp_Skill PRIMARY KEY (SkillNo, EmpNo)
GO

ALTER TABLE Employee  
ADD  CONSTRAINT [FK_1] FOREIGN KEY([DeptNo])
REFERENCES Department (DeptNo)

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT [FK_2] FOREIGN KEY ([EmpNo])
REFERENCES Employee([EmpNo])

GO
ALTER TABLE Emp_Skill
ADD CONSTRAINT [FK_3] FOREIGN KEY ([SkillNo])
REFERENCES Skill([SkillNo])

GO

--1.
select * from Employee

insert into Employee values (1, N'Nguyễn Hoài Phương', '2001-05-11', 2, 7, '2020-02-01', 3200, 1, null , 7, 'phuongnh@gmail.ems.com')
insert into Employee values (2, N'Trần Hữu Toàn', '1999-05-19', 2, 1, '2019-02-17', 2200, 0, null , 6, 'toanth@gmail.ems.com')
insert into Employee values (3, N'Lâm Gia Cảnh', '2001-09-06', 2, 1, '2021-04-15', 1700, 1, null , 4, 'canhlg@gmail.ems.com')
insert into Employee values (4, N'Nguyễn Mai Anh', '2022-02-22', 2, 1, '2022-09-11', 1300, 1, null , 3, 'anhnm@gmail.ems.com')
insert into Employee values (5, N'Đào Minh Trung', '1985-02-28', 1, 7, '2018-02-03', 1500, 1, null , 4, 'trungdm@gmail.ems.com')
insert into Employee values (6, N'Đinh Công Mạnh', '1988-11-13', 1, 7, '2018-06-10', 1500, 1, null , 4, 'manhdc@gmail.ems.com')
insert into Employee values (7, N'Trần Thăng Thiên', '1982-12-31', 4, null, '2016-03-15', 5200, 1, null , 7, 'thientt@gmail.ems.com')
insert into Employee values (8, N'Nguyễn Thế Hoàn', '1984-01-02', 4, 7, '2017-04-22', 4100, 1, null , 7, 'hoannt@gmail.ems.com')
insert into Employee values (9, N'Lâm Tâm Như', '1989-05-26', 4, 7, '2017-05-10', 3100, 1, null , 5, 'nhult@gmail.ems.com')
insert into Employee values (10, N'Hoàng Quốc Bảo', '1998-07-03', 10, 8, '2019-02-23', 1600, 1, null , 5, 'baohq@gmail.ems.com')
insert into Employee values (11, N'Huỳnh Quang Tài', '1999-12-21', 10, 8, '2019-06-10', 1700, 0, null , 5, 'taihq@gmail.ems.com')
insert into Employee values (12, N'Lưu Hoa Kiều', '1998-06-24', 10, 8, '2020-02-28', 1400, 1, null , 4, 'kieulh@gmail.ems.com')
insert into Employee values (13, N'Nguyễn Long', '2000-03-17', 10, 8, '2020-02-28', 1800, 1, null , 5, 'longn@gmail.ems.com')
insert into Employee values (14, N'Đinh Khiết Hoàng', '1997-02-17', 5, 9, '2021-08-18', 2900, 1, null , 6, 'hoangdk@gmail.ems.com')
insert into Employee values (15, N'Phạm Kiệt', '1998-08-26', 5, 9, '2021-10-10', 2500, 1, null , 5, 'kietp@gmail.ems.com')
insert into Employee values (16, N'Đăng Khoa', '1994-07-23', 9, 9, '2022-06-20', 1200, 1, null , 3, 'khoad@gmail.ems.com')


select * from Department

insert into Department values ( N'Alpha', N'Chạy dealine tới sáng')
insert into Department values ( N'Beta', N'Gõ code như múa Piano')
insert into Department values ( N'Gamma', N'Vạch code tìm bug')
insert into Department values ( N'Delta', N'Ngồi không ăn bánh, tới tháng lãnh lương')
insert into Department values ( N'Epsilon', N'Không rời bàn phím')
insert into Department values ( N'Zeta', N'Code không sai, requirement sai')
insert into Department values ( N'Eta', N'Còn thở là còn code')
insert into Department values ( N'Theta', N'Còn thở là còn fix bug')
insert into Department values ( N'Iota', N'Dev đến hơi thở cuối cùng')
insert into Department values ( N'Kappa', N'OT như cơm bữa')

select * from Skill

insert into Skill values ( N'Java',N'Java Web Application Development')
insert into Skill values ( N'JavaScript',N'Vanilla JavaScript')
insert into Skill values ( N'HTML and CSS',N'Website Layout Design')
insert into Skill values ( N'C#',null)
insert into Skill values ( N'C++',null)
insert into Skill values ( N'.NET',null)
insert into Skill values ( N'Python',N'AI-Data Analysis-Big Data')
insert into Skill values ( N'React',null)
insert into Skill values ( N'Angular',null)
insert into Skill values ( N'NoSQL',null)

select * from Emp_Skill

insert into Emp_Skill values (1, 1, 6, '2020-04-12', null)
insert into Emp_Skill values (2, 1, 5, '2020-02-01', null)
insert into Emp_Skill values (3, 1, 7, '2020-02-01', N'Thiết kế giao diện web')
insert into Emp_Skill values (1, 2, 6, '2019-02-17', N'Java Web Developer')
insert into Emp_Skill values (10, 2, 5, '2019-08-28', null)
insert into Emp_Skill values (8, 3, 4, '2021-04-15', null)
insert into Emp_Skill values (2, 3, 5, '2021-04-15', null)
insert into Emp_Skill values (1, 4, 3, '2022-09-11', null)
insert into Emp_Skill values (4, 5, 5, '2018-02-03', null)
insert into Emp_Skill values (6, 5, 4, '2018-02-03', N'ASP.NET')
insert into Emp_Skill values (5, 6, 4, '2018-02-03', null)
insert into Emp_Skill values (7, 7, 7, '2016-03-15', N'AI Research')
insert into Emp_Skill values (7, 8, 7, '2017-04-22', N'Data Science')
insert into Emp_Skill values (7, 9, 5, '2017-05-10', N'Data Analysis')
insert into Emp_Skill values (1, 10, 5, '2019-02-23', null)
insert into Emp_Skill values (10, 11, 5, '2019-06-10', null)
insert into Emp_Skill values (1, 12, 4, '2020-02-28', null)
insert into Emp_Skill values (1, 13, 5, '2020-02-28', null)
insert into Emp_Skill values (10, 13, 5, '2020-04-12', null)
insert into Emp_Skill values (2, 14, 6, '2021-08-18', null)
insert into Emp_Skill values (9, 14, 6, '2021-08-18', null)
insert into Emp_Skill values (7, 14, 5, '2022-03-15', null)
insert into Emp_Skill values (3, 15, 5, '2021-10-10', null)
insert into Emp_Skill values (2, 15, 5, '2021-10-10', null)
insert into Emp_Skill values (9, 15, 5, '2021-10-10', null)
insert into Emp_Skill values (9, 16, 3, '2022-06-20', null)

--2
select e.EmpName,e.EmpNo, e.Email, d.DeptName
from Employee e left join Department d on e.DeptNo = d.DeptNo
where datediff(month, e.StartDate, getdate()) >= 6

--3
select EmpName
from Emp_Skill s inner join Employee e on s.EmpNo = e.EmpNo
				 inner join Skill sk on s.SkillNo = sk.SkillNo
where SkillName in ('C++', '.NET')

--4
select e1.EmpName as EmployeeName, e2.EmpName as ManagerName, e2.Email as ManagerEmail
from Employee e1 left join Employee e2 on e1.MgrNo = e2.EmpNo

--5
select D.DeptName, e.EmpNo, e.EmpName
from Department D left join Employee e on E.DeptNo = D.DeptNo
where (select COUNT(*) 
       from Employee E 
       where E.DeptNo = D.DeptNo) >= 2

--6
select e.EmpName, e.Email, count(ek.SkillNo) as Num_Of_Skill
from Emp_Skill ek left join Employee e on ek.EmpNo = e.EmpNo
				  left join Skill s on ek.SkillNo = s.SkillNo
group by e.EmpName, e.Email
order by EmpName asc

--7
--C1:
select e.EmpName, e.Email, e.BirthDay
from Employee e
where (select count(ek.SkillNo)
	   from Emp_Skill ek
	   where e.EmpNo = ek.EmpNo) >= 2 and e.Status = 1
group by e.EmpName, e.Email, e.BirthDay

--C2:
select e.EmpName, e.Email, e.BirthDay
from Employee e left join Emp_Skill ek ON e.EmpNo = ek.EmpNo
				left join Skill s ON s.SkillNo = ek.SkillNo
where e.status = 1
group by e.EmpName, e.Email, e.BirthDay
having count(s.SkillNo) >= 2;

--8
create view V as
select e.EmpName, s.SkillName, d.DeptName
from Employee e left join Emp_Skill ek ON e.EmpNo = ek.EmpNo
				left join Skill s ON s.SkillNo = ek.SkillNo
				left join Department d on e.DeptNo = d.DeptNo
where e.status = 1

select * from V