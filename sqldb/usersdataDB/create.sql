create table roles(
	id serial primary key,
	name varchar(255)
);

create table users(
	id serial primary key,
	name varchar(255),
	role_id int references roles(id)
);

create table rules(
	id serial primary key,
	can_read boolean,
	can_create boolean,
	can_update boolean,
	can_delete boolean
);

create table role_rules(
	id serial primary key,
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table categories(
	id serial primary key,
	name varchar(255)
);

create table states(
	id serial primary key,
	states varchar(255)
);

create table items(
	id serial primary key,
	name varchar(255),
	price money,
	user_id int references users(id),
	category_id int references categories(id),
	states_id int references states(id)
);

create table comments(
	id serial primary key,
	comment text,
	item_id int references items(id)
);

create table attachs(
	id serial primary key,
	file_name varchar(255),
	item_id int references items(id)
);


