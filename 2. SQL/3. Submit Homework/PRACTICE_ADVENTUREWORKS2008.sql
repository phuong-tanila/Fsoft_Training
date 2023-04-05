Use AdventureWorksLT2008R2
--1.1
--1)
select CustomerID, LastName, FirstName, CompanyName
from [SalesLT].[Customer]

--2)
select Name, ProductNumber, Color from [SalesLT].[Product]

--3)
select CustomerID, SalesOrderNumber from [SalesLT].[SalesOrderHeader]

-------------------------------------------------------------------------
use AdventureWorks2008
--1.2
--1)
select * from [HumanResources].[Employee]
where JobTitle like 'Research and Development Engineer'

--2)
select BusinessEntityID, (FirstName + ' ' + MiddleName + ' ' + LastName) as FullName
from [Person].[Person]
where MiddleName like 'J%'

--3)
select * from [Production].[ProductCostHistory]
where ModifiedDate = '2003-06-17'

--4)
select * from [HumanResources].[Employee]
where JobTitle not like 'Research and Development Engineer'

--5)
select BusinessEntityID, FirstName, MiddleName, LastName, ModifiedDate
from Person.Person
where ModifiedDate > '2000-12-29'

--6)
select BusinessEntityID, FirstName, MiddleName, LastName, ModifiedDate
from Person.Person
where ModifiedDate != '2000-12-29'

--7)
select BusinessEntityID, FirstName, MiddleName, LastName, ModifiedDate
from Person.Person
where ModifiedDate between '2000-12-01' and '2000-12-31'

--8)
select BusinessEntityID, FirstName, MiddleName, LastName, ModifiedDate
from Person.Person
where ModifiedDate not between '2000-12-01' and '2000-12-31'

-------------------------------------------------------------------------
use AdventureWorks2008
--1.3
--1)
select ProductID, Name from [Production].[Product]
where Name like 'Chain%'

--2)
select ProductID, Name from [Production].[Product]
where Name like '%helmet%'

--3)
select ProductID, Name from [Production].[Product]
where Name not like '%helmet%'

--4)
select BusinessEntityID, FirstName, MiddleName, LastName
from [Person].[Person]
where MiddleName like 'E' or MiddleName like 'B'

--5)
--Câu điều kiện ở query thứ nhất sử dụng % nghĩa là tìm chuỗi bắt đầu
--từ ký tự "Ja" và kết thúc chuỗi là ký tự "es", giữa ký tự "Ja" và "es" có thể
--là bất kỳ ký tự gì, bao nhiêu ký tự cũng đc.

--Câu điều kiện ở query thứ hai sử dụng _ nghĩa là tìm chuỗi bắt đầu
--từ ký tự "Ja" và kết thúc chuỗi là ký tự "es", giữa ký tự "Ja" và "es" chỉ chứa
--duy nhất MỘT ký tự bất kỳ.

-------------------------------------------------------------------------
use AdventureWorks2008
--1.4
--1)
select SalesOrderID, OrderDate, TotalDue
from [Sales].[SalesOrderHeader]
where OrderDate BETWEEN '2001-09-01' AND '2001-09-30' AND TotalDue > 1000

--2)
select SalesOrderID, OrderDate, TotalDue
from [Sales].[SalesOrderHeader]
where OrderDate BETWEEN '2001-09-01' AND '2001-09-03' AND TotalDue > 1000

select SalesOrderID, OrderDate, TotalDue
from [Sales].[SalesOrderHeader]
where OrderDate IN ('2001-09-01', '2001-09-02', '2001-09-03') AND TotalDue > 1000

select SalesOrderID, OrderDate, TotalDue
from [Sales].[SalesOrderHeader]
where (OrderDate >= '2001-09-01' AND OrderDate <= '2001-09-03')	AND TotalDue > 1000

--3)
select SalesOrderID, OrderDate, TotalDue, SalesPersonID, TerritoryID
from [Sales].[SalesOrderHeader]
where (SalesPersonID = 279 OR TerritoryID = 6) AND TotalDue > 1000

--4)
select SalesOrderID, OrderDate, TotalDue, SalesPersonID, TerritoryID
from [Sales].[SalesOrderHeader]
where (SalesPersonID = 279 OR TerritoryID IN (4, 6)) AND TotalDue > 1000

--5)
--Sử dụng IN trong WHERE cho phép chọn nhiều giá trị, thay vì phải viết nhiều câu lệnh OR

-------------------------------------------------------------------------
use AdventureWorks2008
--1.5
--1)
select ProductID, Name, Color
from Production.Product
where Color IS NULL

--2)
select ProductID, Name, Color
from Production.Product
where Color IS NULL OR Color NOT LIKE 'Blue'

--3)
select ProductID, Name, Style, Size, Color
from Production.Product
where Style IS NOT NULL 
	  OR Size IS NOT NULL 
	  OR Color IS NOT NULL

-------------------------------------------------------------------------
use AdventureWorks2008
--1.6
--1)
select ProductID, Comments
from [Production].[ProductReview]
where CONTAINS(Comments, 'socks')

--2)
select Title, FileName
from [Production].[Document]
where CONTAINS(*, 'reflector')

--3)
select Title, FileName
from [Production].[Document]
where CONTAINS(*, 'reflector AND NOT seat')

-------------------------------------------------------------------------
use AdventureWorks2008
--1.7 (PART 1)
--1)
select (AddressLine1 + ' ' + ('('+City + ' ' + PostalCode + ')'))
from [Person].[Address]

--2)
select ProductID, ISNULL(Color, 'No Color') AS Color, Name
from [Production].[Product]

--3)
select ProductID, (Name + ': ' + ISNULL(Color, 'No Color')) AS 'Name: Color'
from [Production].[Product]

--4)
select (CAST(ProductID AS varchar) + ': ' + Name) AS 'Description'
from [Production].[Product]

-------------------------------------------------------------------------
use AdventureWorks2008
--1.7 (PART 2)
--1)
select SpecialOfferID, Description, DIFFERENCE(MinQty, MaxQty) AS 'MinQty - MaxQty'
from [Sales].[SpecialOffer]

--2)
select SpecialOfferID, Description, (MinQty * DiscountPct) AS 'MinQty * DiscountPct'
from [Sales].[SpecialOffer]

--3)
select SpecialOfferID, Description, (ISNULL(MaxQty, 10) * DiscountPct) AS 'MaxQty * DiscountPct'
from [Sales].[SpecialOffer]

--4)
--div trả về kết quả là Thương của phép chia
--mod trả về kết quả là Số Dư của phép chia

-------------------------------------------------------------------------
use AdventureWorks2008
--1.8
--1)
select SUBSTRING(AddressLine1,1,10)
from [Person].[Address]

--2)
select SUBSTRING(AddressLine1,10,15)
from [Person].[Address]

--3)
select UPPER(FirstName) AS 'First name', UPPER(LastName) AS 'Last name'
from [Person].[Person]

-------------------------------------------------------------------------
use AdventureWorks2008
--1.9
--1)
select SalesOrderID, OrderDate, ShipDate, DATEDIFF(day, OrderDate, ShipDate) AS 'Number of days'
from [Sales].[SalesOrderHeader]

--2)
select SalesOrderID, CONVERT(varchar, OrderDate, 23) AS 'OrderDate' , CONVERT(varchar, ShipDate, 23) AS 'ShipDate'
from [Sales].[SalesOrderHeader]

--3)
select SalesOrderID, OrderDate, DATEADD(month, 6, OrderDate) AS 'OrderDateAdd'
from [Sales].[SalesOrderHeader]

--4)
select SalesOrderID, OrderDate, DATEPART(year, OrderDate) AS 'Year of order', DATEPART(month, OrderDate) AS 'Month of order'
from [Sales].[SalesOrderHeader]

--5)
--C1:
select SalesOrderID, OrderDate, DATEPART(year, OrderDate) AS 'Year of order', DATENAME(m, OrderDate) AS 'Month of order'
from [Sales].[SalesOrderHeader]

--C2:
select SalesOrderID, OrderDate,
		DATEPART(year, OrderDate) AS 'Year of order',
		CASE
          WHEN DATEPART(month, OrderDate) = 1 THEN 'January'
          WHEN DATEPART(month, OrderDate) = 2 THEN 'February'
          WHEN DATEPART(month, OrderDate) = 3 THEN 'March'
          WHEN DATEPART(month, OrderDate) = 4 THEN 'April'
          WHEN DATEPART(month, OrderDate) = 5 THEN 'May'
          WHEN DATEPART(month, OrderDate) = 6 THEN 'June'
          WHEN DATEPART(month, OrderDate) = 7 THEN 'July'
          WHEN DATEPART(month, OrderDate) = 8 THEN 'August'
          WHEN DATEPART(month, OrderDate) = 9 THEN 'September'
          WHEN DATEPART(month, OrderDate) = 10 THEN 'October'
          WHEN DATEPART(month, OrderDate) = 11 THEN 'November'
          WHEN DATEPART(month, OrderDate) = 12 THEN 'December'
          ELSE 'OTHER'
       END AS 'Month of order'
from [Sales].[SalesOrderHeader]

-------------------------------------------------------------------------
use AdventureWorks2008
--1.10
--1)
select SalesOrderID, ROUND(SubTotal, 2) AS 'SubTotalRounded '
from [Sales].[SalesOrderHeader]

--2)
select SalesOrderID, ROUND(SubTotal, -1) AS 'SubTotalRounded '
from [Sales].[SalesOrderHeader] 

--3)
select SQRT(SalesOrderID) AS 'Sqrt_SalesOrderID'
from [Sales].[SalesOrderHeader]

--4)
select CAST(RAND()*10 + 1 AS INT) AS '1 to 10'

-------------------------------------------------------------------------
use AdventureWorks2008
--1.11
--1)
select SalesOrderID, OrderDate
from [Sales].[SalesOrderHeader]
where YEAR(OrderDate) = 2001

--2)
select SalesOrderID, OrderDate
from [Sales].[SalesOrderHeader]
order by MONTH(OrderDate), YEAR(OrderDate)

--3)
select PersonType, FirstName, MiddleName, LastName
from [Person].[Person]
order by case when PersonType IN ('IN','SP','SC')
		 then LastName
		 else FirstName END