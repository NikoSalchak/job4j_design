create table departments(
    department_id serial primary key,
	name varchar(255)
);

create table employees(
	employee_id serial primary key,
	name varchar(255),
	department_id int references departments(department_id) 
);

insert into departments(name) values('A');
insert into departments(name) values('B');
insert into departments(name) values('D');
insert into departments(name) values('C');

insert into employees(name, department_id) values('Stas', 1);
insert into employees(name, department_id) values('Petr', 1);
insert into employees(name, department_id) values('Niko', 3);
insert into employees(name, department_id) values('Eugene', 3);
insert into employees(name, department_id) values('Victor', 3);
insert into employees(name, department_id) values('Zaur', 3);
insert into employees(name, department_id) values('Mark', 4);
insert into employees(name, department_id) values('Marina', 4);
insert into employees(name, department_id) values('Victoria', 4);
insert into employees(name, department_id) values('Dima', 4);

SELECT a.department_id department_id, a.name name, b.employee_id employee_id, b.name name 
FROM departments a 
LEFT JOIN employees b USING (department_id);

SELECT b.department_id department_id, b.name name, a.employee_id employee_id, a.name name 
FROM employees a 
RIGHT JOIN departments b USING (department_id);

SELECT a.department_id department_id, a.name name, b.employee_id employee_id, b.name name
FROM departments a
RIGHT JOIN employees  b USING (department_id);

SELECT a.department_id department_id, a.name name, b.employee_id employee_id, b.name name
FROM departments a
FULL JOIN employees b USING (department_id);

SELECT a.department_id department_id, a.name name, b.employee_id employee_id, b.name name
FROM departments a
CROSS JOIN employees b ;

SELECT a.department_id as department_id, a.name as name  
FROM departments a
LEFT JOIN employees b USING (department_id)
WHERE employee_id IS NULL;