create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values('computer mouse x7', 990.50);
insert into devices(name, price) values('computer mouse logitech g 550', 3550.50);
insert into devices(name, price) values('computer mouse okclick', 200);
insert into devices(name, price) values('computer mouse A4TECH', 1500.99);
insert into devices(name, price) values('keyboard logitech mk540', 4500);
insert into devices(name, price) values('keyboard melkosoft', 210.10);
insert into devices(name, price) values('keyboard steelSeries', 2990.99);
insert into devices(name, price) values('keyboard XUNFOX', 1890.50);
insert into devices(name, price) values('headphones hyperX', 7750);
insert into devices(name, price) values('headphones melkosoft', 400);
insert into devices(name, price) values('headphones sven', 599.50);
insert into devices(name, price) values('headphones razer', 4990);

insert into people(name) values('Niko');
insert into people(name) values('Dima');
insert into people(name) values('Eugene');
insert into people(name) values('Petr');

insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(6, 1);
insert into devices_people(device_id, people_id) values(10, 1);
insert into devices_people(device_id, people_id) values(1, 2);
insert into devices_people(device_id, people_id) values(7, 2);
insert into devices_people(device_id, people_id) values(9, 2);
insert into devices_people(device_id, people_id) values(3, 3);
insert into devices_people(device_id, people_id) values(5, 3);
insert into devices_people(device_id, people_id) values(12, 3);
insert into devices_people(device_id, people_id) values(4, 4);
insert into devices_people(device_id, people_id) values(8, 4);
insert into devices_people(device_id, people_id) values(11, 4);
insert into devices_people(device_id, people_id) values(12, 2);
insert into devices_people(device_id, people_id) values(12, 2);
insert into devices_people(device_id, people_id) values(9, 2);
insert into devices_people(device_id, people_id) values(9, 2);

select round(AVG(price::numeric), 2) from devices;

SELECT people.name as name, ROUND(AVG(price::numeric), 2) as price
from devices_people
JOIN devices ON device_id = devices.id
JOIN people ON people_id = people.id
GROUP BY people.name
ORDER BY price;

select people.name as name, ROUND(AVG(price::numeric), 2) as price
from devices_people
JOIN devices ON device_id = devices.id
JOIN people ON people_id = people.id
GROUP BY people.name, price
HAVING price > 5000
ORDER BY price;