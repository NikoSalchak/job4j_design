create table type(
	id serial primary key,
	name varchar(255)
);

create table product(
	id serial primary key, 
	name varchar(255), 
	type_id int references type(id), 
	expired_date date, 
	price numeric
);

insert into type(name) values('сок');
insert into type(name) values('сыр');
insert into type(name) values('молоко');
insert into type(name) values('мясо');
insert into type(name) values('фрукты');
insert into type(name) values('чай');
insert into type(name) values('мороженое');

insert into product(name, type_id, expired_date, price) values('сок апельсиновый', 1, '2024-05-10', 100);
insert into product(name, type_id, expired_date, price) values('сок грейпфрутовый', 1, '2024-05-15', 90.90);
insert into product(name, type_id, expired_date, price) values('сок мультифрукторый', 1, '2024-05-06', 110.99);
insert into product(name, type_id, expired_date, price) values('сок яблочный', 1, '2024-05-10', 89.50);
insert into product(name, type_id, expired_date, price) values('сок томатный', 1, '2024-04-29', 80.50);
insert into product(name, type_id, expired_date, price) values('березовый сок', 1, '2024-06-01', 70.50);

insert into product(name, type_id, expired_date, price) values('чеддер', 2, '2024-04-25', 140.50);
insert into product(name, type_id, expired_date, price) values('сыр маскарпоне', 2, '2024-05-26', 199.50);
insert into product(name, type_id, expired_date, price) values('сыр рикота', 2, '2024-04-30', 200);
insert into product(name, type_id, expired_date, price) values('сыр голландский', 2, '2024-05-28', 200);
insert into product(name, type_id, expired_date, price) values('сыр костромской', 2, '2024-05-20', 90.50);
insert into product(name, type_id, expired_date, price) values('сыр гауда', 2, '2024-04-25', 130.10);
insert into product(name, type_id, expired_date, price) values('сыр мимолет', 2, '2024-04-24', 200.50);
insert into product(name, type_id, expired_date, price) values('сыр канталь', 2, '2024-05-20', 350.50);
insert into product(name, type_id, expired_date, price) values('сыр реджано', 2, '2024-06-09', 650.50);
insert into product(name, type_id, expired_date, price) values('сыр дор блю', 2, '2024-12-01', 1000);
insert into product(name, type_id, expired_date, price) values('сыр рокфор', 2, '2024-12-01', 1000);

insert into product(name, type_id, expired_date, price) values('молоко пастеризованное простоквашино', 3, '2024-04-30', 120);
insert into product(name, type_id, expired_date, price) values('молоко миндальное', 3, '2024-05-12', 199.10);
insert into product(name, type_id, expired_date, price) values('молоко топленное ЕЖК', 3, '2024-05-30', 110);

insert into product(name, type_id, expired_date, price) values('мясо курица-филе', 4, '2024-05-01', 400);
insert into product(name, type_id, expired_date, price) values('мясо говядина', 4, '2024-04-29', 450);
insert into product(name, type_id, expired_date, price) values('мясо баранина', 4, '2024-04-28', 450.50);
insert into product(name, type_id, expired_date, price) values('мясо рыба-кета', 4, '2024-05-06', 560);
insert into product(name, type_id, expired_date, price) values('мраморная говядина', 4, '2024-05-02', 1000);

insert into product(name, type_id, expired_date, price) values('ананас', 5, '2024-07-02', 200);
insert into product(name, type_id, expired_date, price) values('мандарины', 5, '2024-05-20', 128.20);
insert into product(name, type_id, expired_date, price) values('бананы', 5, '2024-05-01', 150.25);
insert into product(name, type_id, expired_date, price) values('грейпфруты', 5, '2024-06-01', 140);
insert into product(name, type_id, expired_date, price) values('яблоки', 5, '2024-06-01', 90);
insert into product(name, type_id, expired_date, price) values('апельсины', 5, '2024-06-01', 145.10);

insert into product(name, type_id, expired_date, price) values('иван-чай в пакетиках', 6, '2025-05-01', 190.10);
insert into product(name, type_id, expired_date, price) values('чай черный', 6, '2025-09-02', 290.90);
insert into product(name, type_id, expired_date, price) values('чай зеленый индийский', 6, '2025-04-10', 300.10);

insert into product(name, type_id, expired_date, price) values('мороженое пломбир советский', 7, '2025-06-05', 50.10);
insert into product(name, type_id, expired_date, price) values('мороженое стаканчик', 7, '2025-07-10', 45.50);
insert into product(name, type_id, expired_date, price) values('фруктовый лед', 7, '2025-06-15', 30);
insert into product(name, type_id, expired_date, price) values('мороженое ekzo', 7, '2025-06-10', 75);

SELECT product.id, product.name as name, type_id, expired_date, price
FROM product
JOIN type ON type_id = type.id
WHERE type.name = 'сыр';

SELECT id, name, type_id, expired_date, price
FROM product
WHERE name LIKE '%мороженое%';

SELECT id, name, type_id, expired_date, price
FROM product
WHERE expired_date < current_date;

SELECT id, name, type_id, expired_date, price
FROM product
WHERE price = (SELECT MAX(price) FROM product);

SELECT type.name as type_name, COUNT(product.name)
FROM product
JOIN type ON type_id = type.id
GROUP BY type.name

SELECT product.id, product.name as name, type_id, expired_date, price
FROM product
JOIN type ON type_id = type.id
WHERE type.name = 'сыр' OR type.name = 'молоко';

SELECT type.name AS name, COUNT(product.id)
FROM product
JOIN type ON type_id = type.id
GROUP BY type.name
HAVING COUNT(product.id) < 10;

SELECT type.id type_id, type.name type_name, product.id product_id, product.name name, expired_date, price
FROM product
JOIN type ON type_id = type.id;