use BikeStores

select product_name, category_name, list_price
from [production].[products] p inner join [production].[categories] c
on p.category_id = c.category_id
order by product_name desc


select product_name, category_name, brand_name, list_price
from [production].[products] p inner join [production].[categories] c
								on p.category_id = c.category_id
								inner join [production].[brands] b
								on p.brand_id = b.brand_id
order by product_name desc


select product_name, order_id
from [sales].[order_items] o right join [production].[products] p on o.product_id = p.product_id
order by order_id

select p.product_name, o.order_id, i.item_id, o.order_date
from   [sales].[order_items] i right join [production].[products] p on i.product_id = p.product_id
								left join [sales].[orders] o on i.order_id = o.order_id
order by o.order_id

select p.product_name, o.order_id, i.item_id, o.order_date
from [production].[products] p left join [sales].[order_items] i on p.product_id = i.product_id
								left join [sales].[orders] o on i.order_id = o.order_id
order by o.order_id


-- product name, cate name, store id, store name, quantity
select p.product_name, c.category_name,ss.store_id, ss.store_name, ps.quantity
from [production].[products] p inner join [production].[categories] c
								on p.category_id = c.category_id
								inner join [production].[stocks] ps
								on p.product_id = ps.product_id
								inner join [sales].[stores] ss
								on ps.store_id = ss.store_id
order by store_id

select product_name, order_id
from [sales].[order_items] i right join [production].[products] p  on i.product_id = p.product_id
order by order_id

--lấy những cust nào đang có và đã có mua những order nào
--firstname, lastname, phone, email, order_date, order_status, order_id

select first_name, last_name, phone, email, order_date, order_status, order_id
from [sales].[customers] c left join [sales].[orders] o on c.customer_id = o.customer_id
order by order_status

--anh nhân viên thuộc cửa hàng nào và số order mà anh ấy bán
--fullname, phone, store_name, order_id
select (first_name + ' ' + last_name) as full_name, s.phone, st.store_name, o.order_id
from [sales].[staffs] s left join [sales].[orders] o on s.staff_id = o.staff_id
						left join [sales].[stores] st on s.store_id = st.store_id