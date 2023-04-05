USE BikeStores

select (c.first_name + ' ' + c.last_name) as 'Họ và Tên',
c.first_name as 'Họ',
c.last_name as 'Tên',
c.phone as 'Số điện thoại'
into CustomerList
from Sales.Customers as c

select * from CustomerList

---------------------------------------------
select DISTINCT city from Sales.Customers order by city
select city, state from Sales.Customers order by city

---------------------------------------------
select category_id, avg(list_price) as avg_list_price
from Production.Products
group by category_id
--having avg(list_price) > 500 and avg(list_price) < 1000
having avg(list_price) between 500 and 1000

---------------------------------------------
SELECT category_id,
MAX([list_price]) AS 'max_list_price',
MIN([list_price]) AS 'min_list_price'
FROM [production].[products]
group by category_id
having MAX([list_price]) > 4000 OR MIN([list_price]) < 500

---------------------------------------------
select customer_id,
year(order_date) as order_year,
count(order_id) as order_count
from Sales.orders
group by customer_id, year(order_date)
having count(order_id) >= 2
order by customer_id

---------------------------------------------
DECLARE @date1 DATETIME
DECLARE @date2 DATETIME
SET @date1= '2012-04-07 20:12:22.013'
SET @date2= '2014-02-27 22:14:10.013'
SELECT DATEDIFF(month, @date1, @date2) AS 'Month'
