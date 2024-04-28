create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values('Masha', 'female');
insert into teens(name, gender) values('Pasha', 'male');
insert into teens(name, gender) values('Victoria', 'female');
insert into teens(name, gender) values('Zaur', 'male');
insert into teens(name, gender) values('Marina', 'female');
insert into teens(name, gender) values('Stas', 'male');
insert into teens(name, gender) values('Karina', 'female');
insert into teens(name, gender) values('Boris', 'male');

SELECT a.name, b.name
FROM teens a
CROSS JOIN teens b
WHERE a.gender <> b.gender;