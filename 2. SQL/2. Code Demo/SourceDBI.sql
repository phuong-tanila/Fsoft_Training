
----------------------------------------------DATABASE
--Tạo database 
CREATE DATABASE testDB;

--Xóa database
DROP DATABASE testDB;

------------------------------------------------TABLE
--Tạo table
create table Customer(
	firstName nvarchar(30) not null,
	gender nchar(5) not null, --n là để có dấu
	address nvarchar(50), --xin dư
	phoneNum char(10) --xin nhiêu thì xài nhiêu
)

CONVERT 1-M relationship: lấy khóa chính bên 1 đặt bên nhiều.
CONVERT M-M relationship: tạo ra 1 quan hệ mới, khóa chính quan hệ này
có thể tự sinh(đặt), hoặc lấy thuộc tính khóa chính của 2 quan hệ này
để làm PK, mỗi thuộc tính PK sẽ là khóa ngoại (FK) của quan hệ mới này.
CONVERT 1-1: đặt thuộc tính PK của bên này vào bên kia, cài đặt nó.

--Xóa table
DROP TABLE table_name;

------------------------------------------------COLUMN
--Add column
ALTER TABLE table_name
ADD column_name datatype;

--Sửa column
ALTER TABLE table_name
ALTER COLUMN column_name datatype;

--Xóa column
ALTER TABLE table_name
DROP COLUMN column_name;

-------------------------------------------------VIEW
--Tạo view
CREATE VIEW view_name AS
SELECT column1, column2
FROM table_name
WHERE condition

--Xóa view
DROP VIEW view_name;

--Alter view
ALTER VIEW Tên_View
AS
    SELECT Cột_1, Cột_1, Cột_n
    FROM Tên_bảng
GO

---------------------------------------------------TRIGGER
--Tạo trigger
create trigger tr_insert on [sales].[order_items]
after insert 
as
begin
	update [sales].[orders]
	set total = (select sum(list_price) 
				from [sales].[order_items]
				where order_id in(select order_id from inserted))
	where order_id in(select order_id from inserted)				
end

--Xóa trigger
Drop trigger tr_insert


-----------------------------------------------FUNCTION
--Tạo function
create function tong_doanh_thu (@productID int)
returns float
as
begin
	declare @sum float = 0
	select  @sum = sum(list_price)
			from [sales].[order_items]
			where product_id = @productID
	return @sum
end

--Sử dụng function
select dbo.tong_doanh_thu (20) as fff

--Xóa function
DROP FUNCTION Tên_hàm

-------------------------------------------------PROCEDURE
--Tạo procedure
create proc proc_product_quantity @productID int, @totalQuantity int output
as
begin
	set @totalQuantity = (select sum(quantity) 
							from ProductInventory
							where @productID = ProductID
							group by ProductID)
							
end
--Sử dụng proc
declare @x int
exec proc_product_quantity 1, @x output
select @x as Total

--Sửa proc
ALTER PROC Tên_thủ_tục Khai_báo_tham_số Kiểu_dữ_liệu
AS
    Lệnh A
    Lệnh B
GO
--Xóa proc
DROP PROC Tên_thủ_tục

------------------------------------------------CONSTRAINT
--Add not null
ALTER TABLE Persons
ADD Age int NOT NULL;

--Add check
alter table Customer
add constraint tenCheck check(gender like 'F')

--Add primary key
alter table Customer
add constraint PK_Customer primary key (idCust)

--Add unique
alter table Membership
add constraint UQ_rank unique (rank)

--Add Foreign key
alter table Membership
add constraint FK_Membership_CID_Customer_idCust
foreign key (CID) references Customer (idCust)

--Add default
ALTER TABLE Persons
ADD CONSTRAINT df_City
DEFAULT 'Sandnes' FOR City;
--Xóa default
ALTER TABLE Persons
ALTER COLUMN City DROP DEFAULT;

--Add index
CREATE INDEX idx_pname
ON Persons (LastName, FirstName);
--Xóa index
DROP INDEX table_name.index_name;

--Xóa constraint
ALTER TABLE Persons
DROP CONSTRAINT CHK_PersonAge;

---------------------------------------------------UPDATE
--Update cho 1 bảng
UPDATE Tên_bảng
SET Cột_1 = Giá_trị_1, Cột_2 = Giá_trị_2,... Cột_n = Giá_trị_n
WHERE Điều_kiện

--Update cho nhiều bảng
UPDATE Tên_bảng
    SET Tên_cột = Biểu_thức,...
FROM Tên_bảng_1
    INNER|LEFT|RIGHT JOIN Tên_bảng_2 ON Biểu_thức_liên_kết
WHERE Điều_kiện_sửa_đổi

---------------------------------------------------INSERT
INSERT DEPARTMENTS(Department_id, Department_name, Manager_id, Location_id)
VALUES(280, 'Service', 145, 2500)

---------------------------------------------------DELETE
--Delete cho 1 bảng
DELETE FROM Tên_bảng
WHERE Điểu_kiện

--Delete cho nhiều bảng
DELETE FROM Tên_bảng
FROM Tên_bảng_1
    INNER|LEFT|RIGHT JOIN Tên_bảng_2 ON Biểu_thức_liên_kết
WHERE Điều_kiện_xóa_dữ_liệu

---------------------------------------------------TRUNCATE
TRUNCATE TABLE Tên_bảng --TRUNCATE NHANH HƠN DELETE BỜI NÓ XÓA XONG NÓ SẼ TẠO LẠI TABLE

---------------------------------------------------DISTINCT
SELECT DISTINCT DEPARTMENT_ID
FROM EMPLOYEES

------------------------------------------------XỬ LÝ CHUỖI
--UPPER
SELECT EMPLOYEE_ID, UPPER(FIRST_NAME) + ' ' + UPPER(LAST_NAME) AS NAME, SALARY
FROM EMPLOYEES

--LOWER
SELECT EMPLOYEE_ID, LOWER(FIRST_NAME) + ' ' + LOWER(LAST_NAME) AS NAME, SALARY
FROM EMPLOYEES

--LEFT
SELECT LEFT('sql.edu.vn', 3)

--RIGHT
SELECT RIGHT('sql.edu.vn', 3)

------------------------------------------------ĐỔI DỮ LIỆU
--CAST
SELECT CAST(12.56 AS int)
SELECT CAST(12.56 AS varchar)
SELECT CAST('2020-01-13' AS datetime)

--CONVERT
SELECT CONVERT(nvarchar(50), GETDATE(), 5)

--FORMAT
SELECT FORMAT(GETDATE(), 'dd/MM/yyyy') AS 'Kết quả'
 
 ----------------------------------------------CẤU TRÚC ĐIỀU KHIỂN
 --IF ELSE
IF Điều_kiện
	BEGIN
		Lệnh A
	END
ELSE
	BEGIN
		Lệnh B
	END

--WHILE
DECLARE @N int = 10
DECLARE @S int = 0
DECLARE @i int = 1
WHILE @i <= @N
BEGIN
    SET @S = @S + @i
    SET @i = @i + 1
END

--CASE WHEN
SELECT Last_name, Job_id, Salary,
    CASE Job_id
        WHEN 'IT_PROG' THEN Salary + 100
        WHEN 'ST_CLERK' THEN Salary + 200
        WHEN 'SA_REP' THEN Salary + 300
        ELSE Salary
    END AS "Lương Mới"
FROM EMPLOYEES



--DATE
--DATE			- format  YYYY-MM-DD
--DATETIME		- format: YYYY-MM-DD HH:MI:SS
--SMALLDATETIME - format: YYYY-MM-DD HH:MI:SS
--TIMESTAMP		- format: a unique number


