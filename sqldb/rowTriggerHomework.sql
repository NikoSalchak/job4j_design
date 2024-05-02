insert into products (name, producer, count, price)
	VALUES('product_3', 'producer_3', 8, 115);
	
insert into products (name, producer, count, price)
	VALUES('product_1', 'producer_1', 3, 50);

create or replace function tax()
	returns trigger as
	$$
		BEGIN
			update products
			set price = price * 0.1 + price
			where id = (select id from inserted);
			return new;
		END;
	$$
	LANGUAGE 'plpgsql';
	
create trigger tax_trigger
	after insert on products
	referencing new table as
					inserted
	for each statement
	execute procedure tax();

insert into products (name, producer, count, price)
	VALUES('product_1', 'producer_1', 3, 50);

alter table products disable trigger tax_trigger;

create or replace function tax_for_each_row()
	returns trigger as
	$$	
		BEGIN
			new.price = new.price * 0.1 + new.price;
			return new;
		END;
	$$
	LANGUAGE 'plpgsql';
	
create trigger tax_for_each_row_trigger
	before insert on products
	for each row
	execute procedure tax_for_each_row();

alter table products enable trigger tax_for_each_row_trigger;
	
insert into products (name, producer, count, price)
	VALUES('product_3', 'producer_3', 8, 115);	

create table history_of_price(
	id serial primary key,
	name varchar(50),
	price integer,
	date timestamp
);

create or replace function price_history()
	returns trigger as
	$$
		BEGIN
			insert into history_of_price(name, price, date) 
			values (new.name, new.price, current_timestamp);
			RETURN NEW;
		END;
	$$
	LANGUAGE 'plpgsql';
	
create trigger price_history
	after insert on products
	for each row
	execute procedure price_history();

insert into products (name, producer, count, price) VALUES('product_5', 'producer_5', 10, 200);

select * FROM products 



	
