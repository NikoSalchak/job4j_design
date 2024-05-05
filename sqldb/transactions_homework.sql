create table user_account(
	id serial primary key,
	name varchar(255),
	account numeric
);
insert into user_account(name, account) values('Niko', 1000.00);
insert into user_account(name, account) values('Stas', 450.50);
insert into user_account(name, account) values('Marina', 2000);

begin transaction isolation level serializable;

select * from user_account;

update user_account set account = account - 500 where id = 1;
update user_account set account = account + 500 where id = 2;

begin transaction isolation level serializable;

update user_account set account = account - 1000 where id = 3;
update user_account set account = account + 1000 where id = 2;

commit;