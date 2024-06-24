create table students(
	id serial primary key,
	name varchar(255),
	date_reg timestamp
);

create table solutions(
	id serial primary key,
	student_id int references students(id),
	date_create_solution timestamp
);

select * from students;
select student_id, COUNT(date_create_solution) 
from solutions
GROUP BY student_id
ORDER BY student_id;

insert into students(name, date_reg) VALUES('Petr Ivanov', '2023-05-29 11:30:30');
insert into students(name, date_reg) VALUES('Victor Ivanov', '2023-12-31 11:20:30');
insert into students(name, date_reg) VALUES('Dmitriy Fedorov', '2024-01-01 15:25:08');
insert into students(name, date_reg) VALUES('Marina Ivanova', '2024-01-02 08:30:30');
insert into students(name, date_reg) VALUES('Evgeniya Belova', '2024-01-02 07:48:30');
insert into students(name, date_reg) VALUES('Niko Salchak', '2024-02-15 11:11:10');
insert into students(name, date_reg) VALUES('Victor Victorov', '2024-02-29 11:22:07');
insert into students(name, date_reg) VALUES('Zaur Tregulov', '2024-03-24 16:22:22');
insert into students(name, date_reg) VALUES('Boris Moritov', '2024-03-30 17:11:21');
insert into students(name, date_reg) VALUES('Alexander Skufiev', '2024-03-31 12:22:30');
insert into students(name, date_reg) VALUES('Timofey Berezov', '2024-04-11 12:00:25');
insert into students(name, date_reg) VALUES('Lena Bodrova', '2024-04-14 19:22:54');
insert into students(name, date_reg) VALUES('Fedor Ivasiev', '2024-05-15 12:24:05');
insert into students(name, date_reg) VALUES('Petr Ivanov', '2024-05-19 10:30:30');
insert into students(name, date_reg) VALUES('Victor Berezockii', '2024-05-20 12:05:35');
insert into students(name, date_reg) VALUES('Petr Ivanov', '2024-06-21 19:32:22');

insert into solutions(student_id, date_create_solution) VALUES(1, '2023-05-30 12:30:22');

delete from solutions;
ALTER SEQUENCE solutions_id_seq RESTART WITH 1;

DO
$$
DECLARE
I record;
BEGIN
	FOR I in 1.. 110 LOOP
	insert into solutions(student_id, date_create_solution) VALUES
	(3, '2023-05-29 11:30:30'::timestamp + ('2024-06-21 19:32:22'::timestamp - '2023-05-29 11:30:30'::timestamp) * RANDOM());
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
BEGIN
	FOR I in 1.. 110 LOOP
	insert into solutions(student_id, date_create_solution) VALUES
	(1, '2024-01-01 15:25:08'::timestamp + ('2024-06-24 19:32:22'::timestamp - '2024-01-01 15:25:08'::timestamp) * RANDOM());
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
BEGIN
	FOR I in 1.. 113 LOOP
	insert into solutions(student_id, date_create_solution) VALUES
	(4, '2024-01-02 08:30:30'::timestamp + ('2024-06-24 19:32:22'::timestamp - '2024-01-02 08:30:30'::timestamp) * RANDOM());
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
BEGIN
	FOR I in 1.. 40 LOOP
	insert into solutions(student_id, date_create_solution) VALUES
	(6, '2024-02-15 11:11:10'::timestamp + ('2024-06-24 19:32:22'::timestamp - '2024-02-15 11:11:10'::timestamp) * RANDOM());
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
BEGIN
	FOR I in 1.. 101 LOOP
	insert into solutions(student_id, date_create_solution) VALUES
	(12, '2024-04-14 19:22:54'::timestamp + ('2024-06-24 19:32:22'::timestamp - '2024-04-14 19:22:54'::timestamp) * RANDOM());
	END LOOP;
END;
$$;

SELECT students.id, students.name, date_reg, solutions.id solution_id, date_create_solution
FROM students
	LEFT JOIN solutions ON students.id = solutions.student_id
WHERE DATE_PART('year', date_reg) = 2024
ORDER BY students.id;

SELECT students.name, solved_tasks
FROM (SELECT students.id, COUNT(date_create_solution) solved_tasks
		FROM students
		 JOIN solutions ON students.id = solutions.student_id
		WHERE DATE_PART('year', students.date_reg) = 2024
		GROUP BY students.id
		ORDER BY students.id) t1
JOIN students ON t1.id = students.id;

SELECT students.name, solved_tasks
FROM (SELECT students.id, COUNT(date_create_solution) solved_tasks
		FROM students
			LEFT JOIN solutions ON students.id = solutions.student_id
		WHERE DATE_PART('year', students.date_reg) = 2024
		GROUP BY students.id
		HAVING COUNT(date_create_solution) >= 100
		ORDER BY students.id) t1
JOIN students ON t1.id = students.id;
	



