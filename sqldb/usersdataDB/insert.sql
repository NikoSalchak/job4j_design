insert into roles(name) values('manager');
insert into roles(name) values('seller');
insert into roles(name) values('engineer');
insert into roles(name) values('mover');
insert into roles(name) values('visitor');

insert into users(name, role_id) values('Niko', 1);
insert into users(name, role_id) values('Petr', 2);
insert into users(name, role_id) values('Stas', 3);
insert into users(name, role_id) values('Victor', 4);

insert into rules(can_read, can_create, can_update, can_delete) values('true', 'true', 'true', 'true');
insert into rules(can_read, can_create, can_update, can_delete) values('true', 'true', 'true', 'false');
insert into rules(can_read, can_create, can_update, can_delete) values('true', 'true', 'false', 'false');

insert into role_rules(role_id, rule_id) values(1, 1);
insert into role_rules(role_id, rule_id) values(2, 2);
insert into role_rules(role_id, rule_id) values(3, 2);
insert into role_rules(role_id, rule_id) values(4, 2);
insert into role_rules(role_id, rule_id) values(5, 3);

insert into categories(name) values('компьютерная техника');
insert into categories(name) values('бытовая техника');
insert into categories(name) values('телефоны');
insert into categories(name) values('техсервис');
insert into categories(name) values('ремонт');

insert into states(states) values('выставить');
insert into states(states) values('выставлено');
insert into states(states) values('на складе');
insert into states(states) values('в продаже');
insert into states(states) values('продано');
insert into states(states) values('забронировано');
insert into states(states) values('на ремонте');
insert into states(states) values('забронировано');

insert into items(name, price, user_id, category_id, states_id) values('samsung A8', 200.00, 2, 3, 4);
insert into items(name, price, user_id, category_id, states_id) values('системный блок overprice', 299.00, 1, 1, 1);
insert into items(name, price, user_id, category_id, states_id) values('посудомоечная машина', 450.00, 3, 2, 7);

insert into comments(comment, item_id) values('приоритет в продаже', 1);
insert into comments(comment, item_id) values('предлагать в дополнение чехлы', 1);
insert into comments(comment, item_id) values('возможно оформление в кредит', 1);
insert into comments(comment, item_id) values('поменять видеокарту на менее дорогую', 2);

insert into attachs(file_name, item_id) values('текстовая документация', 1);
insert into attachs(file_name, item_id) values('текстовая документация', 2);
insert into attachs(file_name, item_id) values('лицензия ОС windows 10', 2);
insert into attachs(file_name, item_id) values('текстовая документация', 3);