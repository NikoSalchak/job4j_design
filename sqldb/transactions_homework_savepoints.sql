create table user_account(
	id serial primary key,
	name varchar(255),
	account numeric
);
insert into user_account(name, account) values('Niko', 1000.00);
insert into user_account(name, account) values('Stas', 450.50);
insert into user_account(name, account) values('Marina', 2000);

begin transaction;
select * from user_account;
update user_account set account = account - 1000 where id = 3;
update user_account set account = account + 1000 where id = 1;
select * from user_account;
rollback;

begin transaction;
insert into user_account (name, account) VALUES ('Zaur', 3500);
savepoint first_savepoint;
update user_account set account = account - 3500 where id = 4;
savepoint second_savepoint;
delete from user_account where account = 0;
rollback to first_savepoint;
commit;

begin transaction;
update user_account set account = account - 3000 where id = 4;
update user_account set account = account + 3000 where id = 1;
savepoint first_savepoint;
update user_account set account = account - 3500 where id = 1;
update user_account set account = account + 3500 where id = 4;
savepoint second_savepoint;
delete from user_account where account = 0;
rollback to second_savepoint;
commit;