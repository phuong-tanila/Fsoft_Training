create database test_cascade
use test_cascade
drop database test_cascade

CREATE TABLE Countries(
	CountryID INT PRIMARY KEY,
	CountryName VARCHAR(50),
	CountryCode VARCHAR(3)
)
 
CREATE TABLE States(
	StateID INT PRIMARY KEY,
	StateName VARCHAR(50),
	StateCode VARCHAR(3),
	CountryID INT
)

ALTER TABLE [dbo].[States] ADD CONSTRAINT [FK_States_Countries] FOREIGN KEY([CountryID])
REFERENCES [dbo].[Countries] ([CountryID])
ON DELETE CASCADE

 
ALTER TABLE [dbo].[States] check CONSTRAINT [FK_States_Countries]

INSERT INTO Countries VALUES (1,'United States','USA')
 
INSERT INTO Countries VALUES (2,'United Kingdom','UK')
 
INSERT INTO States VALUES (1,'Texas','TX',1)
INSERT INTO States VALUES (2,'Arizona','AZ',1)

select * from States
select * from Countries

delete from Countries where CountryID = 1

