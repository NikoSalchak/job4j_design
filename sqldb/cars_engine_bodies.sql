create table car_bodies(
	body_id serial primary key,
	name varchar(255)
);

create table car_engines(
	engine_id serial primary key,
	name varchar(255)
);

create table car_transmissions(
	transmission_id serial primary key,
	name varchar(255)
);

create table cars(
	car_id serial primary key,
	name varchar(255),
	body_id int references car_bodies(body_id),
	engine_id int references car_engines(engine_id),
	transmission_id int references car_transmissions(transmission_id)
);

insert into car_bodies(name) values('sedan');
insert into car_bodies(name) values('van');
insert into car_bodies(name) values('coupe');
insert into car_bodies(name) values('pickup');
insert into car_bodies(name) values('station wagon');
insert into car_bodies(name) values('hatchback');
insert into car_bodies(name) values('suv');

insert into car_engines(name) values('1.2 L 8NR-FTS turbo I4');
insert into car_engines(name) values('1.5 L M15C-FKS I3');
insert into car_engines(name) values('2.0 L M20A-FKS I4');
insert into car_engines(name) values('b38 inline-three turbo');
insert into car_engines(name) values('b58 straight-six turbo 3.0 L');
insert into car_engines(name) values('BMW S68T MHEV 4.6 for LAND ROVER');
insert into car_engines(name) values('Nissan HR engine - 1.4 L');
insert into car_engines(name) values('Nissan KR engine — 1.5 L');

insert into car_transmissions(name) values('6-speed EG60 manual');
insert into car_transmissions(name) values('6-speed EG65 manual');
insert into car_transmissions(name) values('k120 CVT with physical first gear');
insert into car_transmissions(name) values('S4-18');
insert into car_transmissions(name) values('5 DS 25');
insert into car_transmissions(name) values('S4-18');

insert into cars(name, body_id, engine_id, transmission_id) values('toyota corolla', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('toyota corolla filder', 5, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id) values('bmw 1 series', 6, 4, 4);
insert into cars(name, body_id, engine_id, transmission_id) values('bmw 3 series', 1, 4, 4);
insert into cars(name, body_id, engine_id, transmission_id) values('bmw x3 ', 7, null, null);
insert into cars(name, body_id, engine_id, transmission_id) values('nissan x-trail ', 7, null, null);

SELECT car_id, a.name car_name, b.name body_name, c.name engine_name, d.name transmission_name
FROM cars a
LEFT JOIN car_bodies b USING (body_id)
LEFT JOIN car_engines c USING (engine_id)
LEFT JOIN car_transmissions d USING (transmission_id);

SELECT b.name body_name
FROM cars a
FULL JOIN car_bodies b USING (body_id)
WHERE car_id IS NULL;

SELECT c.name engine_name
FROM cars a
FULL JOIN car_engines c USING (engine_id)
WHERE car_id IS NULL;

SELECT d.name transmission_name
FROM cars a
FULL JOIN car_transmissions d USING (transmission_id)
WHERE car_id IS NULL;