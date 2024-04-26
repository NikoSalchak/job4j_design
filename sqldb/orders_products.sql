create table products(
	id serial primary key,
	name varchar(255),
	price money
);

create table orders(
	id serial primary key,
	product_ids int[],
	creation_time timestamp
);

insert into products(name, price) values('сахар', 28.00);
insert into products(name, price) values('яблоки', 110.00);
insert into products(name, price) values('масло', 120.00);
insert into products(name, price) values('хлеб', 30.00);
insert into products(name, price) values('мед', 200.00);

insert into orders(product_ids, creation_time) values(array[1, 4], '2024-04-26 12:05:55');
insert into orders(product_ids, creation_time) values(array[1, 3], '2024-04-26 12:06:40');
insert into orders(product_ids, creation_time) values(array[2, 5], '2024-04-26 12:07:25');
insert into orders(product_ids, creation_time) values(array[3], '2024-04-26 12:25:10');

SELECT id, name, price, product_id
FROM (select unnest(product_ids) as product_id, creation_time from orders) t1
JOIN products ON product_id = products.id;

SELECT id, name, price, product_id
FROM (select unnest(product_ids) as product_id, creation_time from orders) t1
JOIN products ON product_id = products.id
WHERE price::numeric > 100.00;

SELECT t1.id order_id, sum(price)::numeric order_price 
FROM (select id, unnest(product_ids) as product_id, creation_time from orders) t1
JOIN products ON product_id = products.id
GROUP BY order_id
ORDER BY order_id;