create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values('Bee', 3000, NULL);
insert into fauna(name, avg_age, discovery_date) values('Wolf', 20000, NULL);
insert into fauna(name, avg_age, discovery_date) values('Belted kingfisher', 14000, '1850-12-01');
insert into fauna(name, avg_age, discovery_date) values('Belted kingfisher', 14000, '1850-04-01'); 
insert into fauna(name, avg_age, discovery_date) values('Przewalskis horse', 49900, '1881-01-01');
insert into fauna(name, avg_age, discovery_date) values('Loriciferans', 100000, '1983-07-04');
insert into fauna(name, avg_age, discovery_date) values('Okapi', 21000, '1901-11-15');
insert into fauna(name, avg_age, discovery_date) values('Big Red Jellyfish', 100000, '2003-06-22');

SELECT *
FROM fauna
WHERE name lIKE '%fish%';

SELECT * 
FROM fauna
WHERE avg_age BETWEEN 10000 AND 21000;

SELECT * 
FROM fauna
WHERE discovery_date IS NULL;

SELECT * 
FROM fauna
WHERE discovery_date < '1950-01-01';