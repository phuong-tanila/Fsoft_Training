--Question a)
create database BankDatabase
use BankDatabase

create table Person(
	PersonId int identity(1,1) not null,
	Title nvarchar(5),
	FirstName nvarchar(50) not null,
	LastName nvarchar(50) not null,
	DateOfBirth datetime not null,
	Email varchar(50),
	Debt decimal(10,3)
)
alter table Person
add constraint PK_Per primary key(PersonId)

alter table Person
add constraint chk_Email check (Email like '%@%')

alter table Person
add constraint chk_Email1 unique(Email)

-- Create table ContactDetails, OfficeTimeOnly = 1: office time, 0: any time
create table ContactDetails(
	ContactId int identity(1,1) not null,
	PersonId int not null,
	ContactType nvarchar(30),
	PhoneNumber int not null,
	Address nvarchar(2000) not null,
	OfficeTimeOnly bit not null
)
alter table ContactDetails  
add constraint [FK_1] foreign key(PersonId) references Person (PersonId)

alter table ContactDetails
add constraint chk_PhoneNumber unique(PhoneNumber)

create table CreditCard(
	CreaditCardID int not null,
	CardType varchar(20) not null,
	CardNumber int not null,
	ExpMonth int not null,
	ExpYear int not null
)

alter table CreditCard
add constraint PK_CreditCard primary key(CreaditCardID)

alter table CreditCard
add constraint chk_CreaditCardID unique(CreaditCardID)

alter table CreditCard
add constraint chk_CardType
	check (CardType='SuperiorCard' OR CardType='Vista' OR CardType='Distinguish' OR CardType='ColonialVoice')

alter table CreditCard
add constraint chk_ExpMonth
	check (ExpMonth=(1) OR ExpMonth=(2) OR ExpMonth=(3) OR ExpMonth=(4) OR ExpMonth=(5) OR ExpMonth=(6) OR ExpMonth=(7) OR ExpMonth=(8) OR ExpMonth=(9) OR ExpMonth=(10) OR ExpMonth=(11) OR ExpMonth=(12))

-- Create table PersonCreditCard, IsOwner = 1: owner, 0: not owner
create table PersonCreditCard(
	PersonId int not null,
	CreaditCardID int not null,
	ModifiedDate datetime not null,
	IsOwner bit not null,
	Balance decimal(10,3)
)

alter table PersonCreditCard  
add constraint [FK_2] foreign key(PersonId) references Person (PersonId)

alter table PersonCreditCard  
add constraint [FK_3] foreign key(CreaditCardID) references CreditCard (CreaditCardID)

--Question b)

--Person
insert into Person values ('Mr', N'Nguyễn', N'Hoài Phương', '2001-05-11', 'phuongnh@gmail.com', 10000)
insert into Person values ('Mrs', N'Trần', N'Mai Anh', '1985-03-14', 'anhtm@fsoft.com', -1000)
insert into Person values ('Mr', N'John', N'Peter', '1973-06-01', 'peter@corp.com', 2300)
insert into Person values ('Mr', N'Rey', N'Silva', '1986-12-10', 'silva@gmail.com', -30000)
insert into Person values ('Mrs', N'Kate', N'Swift', '1977-04-02', 'swiftkate@gmail.com', 8000)
insert into Person values ('Mrs', N'Kathy', N'Kim', '2000-11-23', 'kim123@gmail.com', 7230)
insert into Person values ('Mr', N'Trịnh', N'Minh Quân', '1997-07-30', 'quantm@gmail.com', -300)
insert into Person values ('Mr', N'Đinh', N'Công Bình', '1992-12-21', 'binhdc@gmail.com', 12000)
insert into Person values ('Mr', N'Lâm', N'Vinh Anh', '1963-05-02', 'anhlv@gmail.com', -400)
insert into Person values ('Mrs', N'Tạ', N'Cúc Huyền', '1975-04-29', 'huyentc@gmail.com', 250)
insert into Person values ('Mr', N'Huỳnh', N'Công Hiếu', '2000-08-21', 'hieuhc@gmail.com', 10600)
insert into Person values ('Mrs', N'Trần', N'Thu Thủy', '1999-02-14', 'thuytt@gmail.com', -2100)
insert into Person values ('Mr', N'Kevin', N'Ken', '1995-07-24', 'kevin@gmail.com', 3000)
insert into Person values ('Mr', N'Johnny', N'Rey', '1994-03-16', 'johnnyrey@gmail.com', 1200)
insert into Person values ('Mrs', N'Taylor', N'Tina', '1989-11-11', 'tina@gmail.com', 3000)


--ContactDetails
insert into ContactDetails values (1, 'Home', 1289090123, N'Tây Ninh', 1)
insert into ContactDetails values (2, 'Office', 1275090003, N'Hồ Chí Minh', 1)
insert into ContactDetails values (3, 'Office', 1289000123, N'Quận 1', 1)
insert into ContactDetails values (4, 'Home', 1289097777, N'Quận 10', 0)
insert into ContactDetails values (5, 'Home', 1289090555, N'Thủ Đức', 0)
insert into ContactDetails values (6, 'Office', 1289099876, N'Quận 3', 1)
insert into ContactDetails values (7, 'Office', 1275090123, N'Bình Thạnh', 1)
insert into ContactDetails values (8, 'Office', 1289222223, N'Phú Nhuận', 0)
insert into ContactDetails values (9, 'Home', 1289052523, N'Quận 9', 0)
insert into ContactDetails values (10, 'Office', 1235350123, N'Quận 9', 1)
insert into ContactDetails values (11, 'Office', 1244440123, N'Quận 5', 1)
insert into ContactDetails values (12, 'Home', 1289686823, N'Quận 7', 0)
insert into ContactDetails values (13, 'Home', 1281313123, N'Quận 2', 0)
insert into ContactDetails values (14, 'Office', 1286969123, N'Quận 2', 1)
insert into ContactDetails values (15, 'Home', 1280505125, N'Quận 12', 0)


--CreditCard
insert into CreditCard values (2878123, 'SuperiorCard', 1345671234, 12, 2025)
insert into CreditCard values (2504123, 'Vista', 1245671234, 10, 2024)
insert into CreditCard values (1348123, 'Distinguish', 1678971234, 2, 2023)
insert into CreditCard values (1001123, 'Vista', 1000071234, 11, 2022)
insert into CreditCard values (2833323, 'ColonialVoice', 1909071234, 3, 2025)
insert into CreditCard values (2444123, 'SuperiorCard', 1929271234, 7, 2026)
insert into CreditCard values (1328123, 'Vista', 1345000234, 10, 2025)
insert into CreditCard values (2855523, 'Distinguish', 1399911234, 9, 2023)
insert into CreditCard values (2333123, 'ColonialVoice', 1341111234, 5, 2024)
insert into CreditCard values (2878000, 'Vista', 1333551234, 2, 2024)
insert into CreditCard values (2873523, 'SuperiorCard', 1341765234, 4, 2026)
insert into CreditCard values (1757523, 'ColonialVoice', 1272771234, 8, 2024)
insert into CreditCard values (1414123, 'SuperiorCard', 1797971234, 10, 2024)
insert into CreditCard values (2870003, 'SuperiorCard', 1300071234, 3, 2026)
insert into CreditCard values (2888032, 'SuperiorCard', 1282871234, 6, 2025)

--PersonCreditCard
insert into PersonCreditCard values (1, 2878123, '2022-01-12', 1, 32000)
insert into PersonCreditCard values (2, 2504123, '2022-01-12', 1, 8000)
insert into PersonCreditCard values (3, 1348123, '2022-01-12', 1, 300)
insert into PersonCreditCard values (4, 1001123, '2022-01-12', 1, 24000)
insert into PersonCreditCard values (5, 2833323, '2022-01-12', 1, 5000)
insert into PersonCreditCard values (6, 2444123, '2022-01-12', 1, 200)
insert into PersonCreditCard values (7, 1328123, '2022-01-12', 1, 4030)
insert into PersonCreditCard values (8, 2855523, '2022-01-12', 0, 0)
insert into PersonCreditCard values (9, 2333123, '2022-01-12', 0, 350)
insert into PersonCreditCard values (10, 2878000, '2022-01-12', 1, 12000)
insert into PersonCreditCard values (11, 2873523, '2022-01-12', 1, 3000)
insert into PersonCreditCard values (12, 1757523, '2022-01-12', 1, 5000)
insert into PersonCreditCard values (13, 2870003, '2022-01-12', 0, 7000)
insert into PersonCreditCard values (14, 1414123, '2022-01-12', 1, 25500)
insert into PersonCreditCard values (15, 2888032, '2022-01-12', 0, 13000)

--Question c)
select top 3 * from Person where Debt > 0 order by Debt desc

--Question d)
select c.PhoneNumber, c.Address
from ContactDetails c inner join Person p on c.PersonId = p.PersonId
where p.Email LIKE 'peter@corp.com'

--Question e)
update CreditCard set ExpMonth = ExpMonth + 6
where CreaditCardID = (select pc.CreaditCardID
					   from PersonCreditCard pc inner join CreditCard cc on pc.CreaditCardID = cc.CreaditCardID
					   where pc.PersonId = 13)

--Question f)
select (p.FirstName + ' ' + p.LastName) as 'Full name', sum(pc.Balance) as 'Total balance'
from Person p inner join PersonCreditCard pc on p.PersonId = pc.PersonId
where pc.IsOwner = 1
group by p.FirstName, p.LastName
having sum(pc.Balance) < 0
