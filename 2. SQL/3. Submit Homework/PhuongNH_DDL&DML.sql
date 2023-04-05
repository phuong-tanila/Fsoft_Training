--Q1:
CREATE DATABASE Movie_Collection
USE Movie_Collection
DROP DATABASE Movie_Collection

CREATE TABLE Movie(
	Movie_Name NVARCHAR(100) NOT NULL,
	Duration INT NOT NULL, 
	Genre INT NOT NULL,
	Director NVARCHAR(100) NOT NULL,
	Amount_of_money MONEY NOT NULL,
	Comments TEXT,
	PRIMARY KEY (Movie_Name, Genre, Director),
	CONSTRAINT GreaterEqual1 CHECK (Duration >= 1),
	CONSTRAINT RangeGenre CHECK (Genre >= 1 AND Genre <= 8 )
)

CREATE TABLE Actor(
	 Actor_Name NVARCHAR(100) NOT NULL, 
	 Age INT NOT NULL, 
	 Average_movie_salary MONEY NOT NULL, 
	 Nationality NVARCHAR(100) NOT NULL,
	 PRIMARY KEY (Actor_Name, Age, Nationality)
)

CREATE TABLE ActedIn(
	Movie_Name NVARCHAR(100),
	Genre INT,
	Director NVARCHAR(100),
	Actor_Name NVARCHAR(100),
	Age INT, 
	Nationality NVARCHAR(100),
	PRIMARY KEY (Movie_Name, Genre, Director, Actor_Name, Age, Nationality) 
)
ALTER TABLE Movie ADD ImageLink VARCHAR(200) UNIQUE;

ALTER TABLE ActedIn  WITH CHECK ADD  CONSTRAINT [FK_ActedIn_Movie] FOREIGN KEY(Movie_Name, Genre, Director)
REFERENCES Movie(Movie_Name, Genre, Director)
ALTER TABLE ActedIn  WITH CHECK ADD  CONSTRAINT [FK_ActedIn_Actor] FOREIGN KEY (Actor_Name, Age, Nationality)
REFERENCES Actor(Actor_Name, Age, Nationality)
ON UPDATE CASCADE
ON DELETE CASCADE

 
--ALTER TABLE ActedIn CHECK CONSTRAINT [FK_ActedIn_Movie]

--add data into table Movie:
insert into movie values (N'Tây Du Ký', 90, 2, N'Dương Khiết', 50000, null, null)
insert into movie values ('Peaky Blinders', 113, 4, 'Steven Knight', 180000, 'Good', 'abx.com')
insert into movie values ('Spider Man: No Way Home', 120, 1, 'Jon Watts', 70000, 'Boring', 'xyz.org')
insert into movie values ('DC League of Super-Pets', 105, 2, 'Jared Stern', 150000, 'Top film in 2022', 'xam.net')
insert into movie values ('John Wick', 118, 1, 'Derek Kolstad', 35000, 'Excelent', 'max.com')
insert into movie values ('Fast And Furious 8', 136, 1, 'F. Gary Gray', 185000, 'Great', 'lol.com')
insert into movie values ('xXx: Return Of Xander Cage', 110, 1, 'D.J. Caruso', 205000, 'So Excited', 'linkpng.com')
insert into movie values (N'Trường Học Uy Long', 98, 3, N'Trần Gia Thường', 15000, N'Hay quá', 'linkpng.abc')
insert into movie values (N'Mỹ Nhân Ngư', 93, 3, N'Châu Tinh Trì', 77000, N'Quá hài', 'tinhtinh.com')
insert into movie values (N'Dòng Máu Anh Hùng', 104, 1, N'Charlie Nguyễn', 48000, N'Mãn nhãn', 'phimviet.com')
select * from movie

--add data into table Actor:
insert into actor values ('Keanu Reeves', 58, 120000, 'Canada')
insert into actor values ('Cillian Murphy', 46, 53000, 'Ireland')
insert into actor values ('Joe Cole', 34, 20000, 'England')
insert into actor values ('Tom Holland', 26, 62000, 'England')
insert into actor values ('Donnie Yen', 59, 98000, 'China')
insert into actor values ('Dwayne Johnson', 50, 106000, 'US')
insert into actor values ('Kevin Hart', 43, 50000, 'US')
insert into actor values (N'Lục Tiểu Linh Đồng', 63, 5600, 'China')
insert into actor values ('Vin Diesel', 55, 175000, 'US')
insert into actor values ('Tony Jaa', 46, 97000, 'Thailand')
insert into actor values ('Jason Statham', 55, 172000, 'England')
insert into actor values (N'Châu Tinh Trì', 60, 32000, 'China')
insert into actor values (N'Johnny Trí Nguyễn', 48, 16000, N'Việt Nam')
insert into actor values (N'Ngô Thanh Vân', 43, 12000, N'Việt Nam')
insert into actor values (N'Dustin Nguyễn', 60, 6000, N'Việt Nam')
insert into actor values (N'Nguyễn Thắng', 52, 1100, N'Việt Nam')
insert into actor values ('Michelle Rodriguez', 44, 23000, 'US')
insert into actor values ('Tyrese Gibson', 44, 36000, 'US')
select * from actor

--add data into table ActedIn:
insert into ActedIn values ('DC League of Super-Pets', 2, 'Jared Stern', 'Kevin Hart',  43, 'US')
insert into ActedIn values ('DC League of Super-Pets', 2, 'Jared Stern', 'Keanu Reeves', 58, 'Canada')
insert into ActedIn values ('DC League of Super-Pets', 2, 'Jared Stern', 'Dwayne Johnson', 50, 'US')
insert into ActedIn values ('Fast And Furious 8', 1, 'F. Gary Gray', 'Vin Diesel', 55, 'US')
insert into ActedIn values ('Fast And Furious 8', 1, 'F. Gary Gray', 'Jason Statham', 55, 'England')
insert into ActedIn values ('Fast And Furious 8', 1, 'F. Gary Gray', 'Tyrese Gibson', 44, 'US')
insert into ActedIn values ('Fast And Furious 8', 1, 'F. Gary Gray', 'Dwayne Johnson', 50, 'US')
insert into ActedIn values ('Fast And Furious 8', 1, 'F. Gary Gray', 'Michelle Rodriguez', 44, 'US')
insert into ActedIn values (N'Tây Du Ký', 2, N'Dương Khiết', N'Lục Tiểu Linh Đồng',  63, 'China')
insert into ActedIn values ('Spider Man: No Way Home', 1, 'Jon Watts', 'Tom Holland',  26, 'England')
insert into ActedIn values ('John Wick', 1, 'Derek Kolstad', 'Keanu Reeves', 58, 'Canada')
insert into ActedIn values ('John Wick', 1, 'Derek Kolstad', 'Donnie Yen', 59, 'China')
insert into ActedIn values ('Peaky Blinders', 4, 'Steven Knight', 'Cillian Murphy', 46, 'Ireland')
insert into ActedIn values ('Peaky Blinders', 4, 'Steven Knight', 'Joe Cole', 34, 'England')
insert into ActedIn values ('xXx: Return Of Xander Cage', 1, 'D.J. Caruso', 'Vin Diesel', 55, 'US')
insert into ActedIn values ('xXx: Return Of Xander Cage', 1, 'D.J. Caruso', 'Donnie Yen', 59, 'China')
insert into ActedIn values ('xXx: Return Of Xander Cage', 1, 'D.J. Caruso', 'Tony Jaa', 46, 'Thailand')
insert into ActedIn values (N'Dòng Máu Anh Hùng', 1, N'Charlie Nguyễn', N'Ngô Thanh Vân', 43, N'Việt Nam')
insert into ActedIn values (N'Dòng Máu Anh Hùng', 1, N'Charlie Nguyễn', N'Johnny Trí Nguyễn', 48, N'Việt Nam')
insert into ActedIn values (N'Dòng Máu Anh Hùng', 1, N'Charlie Nguyễn', N'Dustin Nguyễn', 60, N'Việt Nam')
insert into ActedIn values (N'Dòng Máu Anh Hùng', 1, N'Charlie Nguyễn', N'Nguyễn Thắng', 52, N'Việt Nam')
insert into ActedIn values (N'Trường Học Uy Long', 3, N'Trần Gia Thường', N'Châu Tinh Trì', 60, 'China')
select * from ActedIn

--Q2:

delete from actor where Nationality LIKE 'Canada'
delete from movie where Duration = 137

update actor set Actor_Name = Actor_Name + ' updated' where Age > 26

--Q3:

--1
 select * from actor where age > 50
--2
 select Actor_Name, Average_movie_salary 
 from actor 
 order by Average_movie_salary desc
--3
 select Movie_Name from ActedIn where Actor_Name = 'Dwayne Johnson'
--4
 select Movie_Name, Count(Actor_Name) AS Num_Of_Actor
 from ActedIn
 group by Movie_Name
 having Count(Actor_Name) > 3
