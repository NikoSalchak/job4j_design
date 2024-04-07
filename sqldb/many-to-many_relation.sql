create table Houses(
id serial primary key,
address varchar(255)
);

create table Owner(
id serial primary key,
name varchar(255),
);

create table house_owners(
id serial primary key,
House_id int references Houses(id),
Owner_id int references Owner(id)
);

insert into House(address) values('Ekaterinburg, Lunacharskogo 210a-52');
insert into Owner(name) values('Niko');
insert into House_owners(House_id, Owner_id) values (1, 1);