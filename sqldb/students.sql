create table students (
id serial primary key,
name varchar(80),
surname varchar(80),
birthdate date,
on_grant boolean
);
insert into students (name, surname, birthdate, on_grant) values ('Niko', 'Salchak', '12-10-1995', 'true');
update set on_grant = 'true';
delete from students;