create table House(
id serial primary key,
address varchar(255)
);

create table Owner(
id serial primary key,
name varchar(255),
House_id int references House(id) unique
);
insert into House(address) values('Ekaterinburg, Lunacharskogo 210a-52');
insert into Owner(name, House_id) values('Niko', 1);