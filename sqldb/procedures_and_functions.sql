create or replace procedure insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
language 'plpgsql'
as $$
	BEGIN
		insert into products (name, producer, count, price)
		values(i_name, prod, i_count, i_price);
	END
	$$;

call insert_data('product_2', 'producer_2', 15, 32);


create or replace procedure update_data(u_count integer, tax float, u_id integer)
language 'plpgsql'
as $$
	BEGIN
		if u_count > 0 THEN
			update products
			set count = count - u_count
			where id = u_id;
		end if;
		if tax > 0 THEN
			update products
			set price = price + price * tax;
		end if;
	END;
	$$;
	
call update_data(1, 0.2, 6);

call insert_data('product_1', 'producer_1', 3, 50);
call insert_data('product_3', 'producer_3', 8, 115);
call update_data(0, 0.2, 0)

select * FROM products;
delete from products;
alter sequence products_id_seq restart with 1;

create or replace function f_insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
returns void
language 'plpgsql'
as
$$
	begin
		insert into products (name, producer, count, price)
		values(i_name, prod, i_count, i_price);
	end;
$$;
select f_insert_data('product_1', 'producer_1', 25, 50);

create or replace function f_update_data(u_count integer, tax float, u_id integer)
returns integer
language 'plpgsql'
as
$$
	declare
		result integer;
	begin
		if u_count > 0 THEN
			update products
			set count = count - u_count
			where id = u_id;
			select into result count
			from products
			where id = u_id;
		end if;
		if tax > 0 THEN
			update products
			set price = price + price * tax;
			select into result sum(price)
			from products;
		end if;
		return result;
	end;
$$;

select f_update_data(5, 0, 1);
select f_insert_data('product_2', 'producer_2', 15, 32);
select f_insert_data('product_3', 'producer_3', 8, 115);
select f_update_data(0, 0.2, 0);

create or replace procedure delete_data( u_id integer)
language 'plpgsql'
as $$
	BEGIN
		if u_id <= 0 THEN
			DELETE FROM products
			where count <= 0;
		end if;
		if u_id > 0 THEN
			DELETE FROM products
			where id = u_id;
		end if;
	END;
	$$;

drop procedure delete_data( u_id integer);
select f_insert_data('product_4', 'producer_4', 8, 86);
select f_insert_data('product_5', 'producer_3', -2, 40);
call delete_data(0);
select * from products;

create or replace function discount_product(discount float, u_id integer)
returns float
language 'plpgsql'
as
$$
	declare
		result float;
	begin
			select into result price * discount
			from products
			where id = u_id;
			update products
			set price = price - price * discount
			where id = u_id AND count > 0 AND count < 15;
		return result;
	end;
$$;
drop function discount_product(discount float, u_id integer);
select discount_product(0.25, 5);
select * from products;
