create table customers (
	id serial primary key,
	first_name text,
	last_name text,
	age int,
	country text
);

insert into customers (first_name, last_name, age, country)
VALUES('Niko', 'Salchak', 28, 'Russia'),
('Zaur', 'Tregulov', 36, 'Russia'),
('Marina', 'Ivanova', 34, 'Switzerland'),
('Stas', 'Petrov', 40, 'Russia'),
('Maxim', 'Kozlov', 36, 'Russia'),
('Petr', 'Arsentev', 38, 'Russia'),
('Mori', 'Chan', 28, 'Japan');

SELECT * 
FROM customers
WHERE age = (select MIN(age) FROM customers);

create table orders (
	id serial primary key,
	amount int,
	customer_id int references customers(id)
);

insert into orders(amount, customer_id)
VALUES(300, 1),
(100, 1),
(300, 2),
(450, 3),
(200, 4),
(560, 5),
(120, 5);

SELECT * 
FROM customers
WHERE id NOT IN (select customer_id from orders);