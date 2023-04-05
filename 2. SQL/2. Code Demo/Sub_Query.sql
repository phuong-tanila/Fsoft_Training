use BikeStores

--Correlated subquery
select product_name, list_price, category_id
from [production].[products] p1
where list_price IN (
					select Max(p2.list_price)
					from [production].[products] p2
					where p2.category_id = p1.category_id
					group by p2.category_id)
order by category_id, product_name

--Nested subquery
select order_id, order_date,
	(select MAX(list_price)
	 from [sales].[order_items] i
	 where i.order_id = o.order_id) as max_list_price
from [sales].[orders] o
order by order_date desc

--Ex:
select product_id, product_name
from [production].[products] p
where category_id IN (select category_id
					  from [production].[categories] c
					  where category_name IN ('mountain bikes', 'road bikes' ))
order by product_id

--Ex:
select product_name, list_price
from [production].[products] p
where list_price >= any (select avg(list_price)
						from [production].[products]
						group by brand_id)

--Ex:
select customer_id, first_name, last_name, city
from [sales].[customers]
where customer_id in (select customer_id
						 from [sales].[orders]
						 where year(order_date) = 2017)
order by first_name, last_name
--------------
select customer_id, first_name, last_name, city
from [sales].[customers] c
where exists (select customer_id
						 from [sales].[orders] o
						 where o.customer_id = c.customer_id and
						 year(order_date) = 2017)
order by first_name, last_name

--Ex:
select avg(order_count) as average_order_count_by_staff
from ( select staff_id, count(order_id) as order_count
	   from [sales].[orders]
	   group by staff_id) as A --phải đặt tên cho table mới tạo ở from