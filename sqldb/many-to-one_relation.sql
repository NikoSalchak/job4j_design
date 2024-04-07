create table shared_owners(
id serial primary key,
name varchar(255),
House_id int references House(id)
);

create table House(
id serial primary key,
address varchar(255),
);
insert into shared_owners(name, House_id) values('Niko', 1);
insert into House(address) values('Ekaterinburg lunacharskogo 210a-52');