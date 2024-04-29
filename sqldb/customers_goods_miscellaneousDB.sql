create table customers(
	customer_id serial primary key,
	name varchar(255),
	sex varchar(255)
);

create table goods(
	good_id serial primary key,
	name varchar(255),
	price numeric
);

create table customers_actions(
	purchase_id serial primary key,
	action varchar(255),
	time timestamp,
	goods_ids int[],
	customer_id int references customers(customer_id)
);

insert into customers(name, sex) values('Niko', 'male');
insert into customers(name, sex) values('Victor', 'male');
insert into customers(name, sex) values('Marina', 'female');
insert into customers(name, sex) values('Zaur', 'male');
insert into customers(name, sex) values('Tatyana', 'female');

insert into goods(name, price) values('средство для бритья', 300.50);
insert into goods(name, price) values('набор кастрюль', 5990.50);
insert into goods(name, price) values('шоколад milka', 80);
insert into goods(name, price) values('тетрадь 90 л', 50);
insert into goods(name, price) values('чайник', 2000.11);
insert into goods(name, price) values('зарядное устройство для ноутбуков универсальное', 2599.99);
insert into goods(name, price) values('зубная паста', 80);
insert into goods(name, price) values('набор ножей', 2700);
insert into goods(name, price) values('стиральный порошок', 549.10);

insert into customers_actions(action, time, goods_ids, customer_id) values('purchase', '2024-04-27 12:55:05', array[1, 3, 4, 9], 1);
insert into customers_actions(action, time, goods_ids, customer_id) values('purchase', '2024-04-27 13:07:55', array[2, 3], 3);
insert into customers_actions(action, time, goods_ids, customer_id) values('purchase', '2024-04-27 13:49:15', array[6], 2);
insert into customers_actions(action, time, goods_ids, customer_id) values('purchase', '2024-04-27 13:55:47', array[7, 9], 4);
insert into customers_actions(action, time, goods_ids, customer_id) values('refund', '2024-04-27 14:15:15', array[6], 2);


CREATE VIEW show_purchases_without_refund as SELECT customer_id, customer_name, good_id, t4.name product_name
FROM (select purchase_id, action, unnest(goods_ids) good_id, customer_id, t2.name customer_name
		from customers_actions t1	
		JOIN customers t2 USING(customer_id)
	 WHERE t1.customer_id NOT IN (SELECT customer_id 
							 FROM customers_actions 
							WHERE action = 'refund')
	 ) t3
JOIN goods t4 USING(good_id);

SELECT * FROM show_purchases_without_refund;
