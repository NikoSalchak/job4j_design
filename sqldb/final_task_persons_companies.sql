create table company(
	id integer NOT NULL,
	name character varying,
	CONSTRAINT company_pkey PRIMARY KEY (id)
);

create table person(
	id integer NOT NULL,
	name character varying,
	company_id integer references company(id),
	CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) VALUES(1, 'Samsung');
insert into company(id, name) VALUES(2, 'Nissan');
insert into company(id, name) VALUES(3, 'BMW');
insert into company(id, name) VALUES(4, 'Nestle');
insert into company(id, name) VALUES(5, 'GymShark');
insert into company(id, name) VALUES(6, 'Nike');
insert into company(id, name) VALUES(7, 'CBER');

DO
$$
DECLARE
I record;
VNUM INTEGER := 1;
BEGIN
	FOR I IN 1.. 10 LOOP
	insert into person(id, name, company_id) VALUES
	(0 + VNUM, 'person' || VNUM, 1);
	
	VNUM := VNUM + 1;
	
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
VNUM INTEGER := 1;
PERSON INTEGER := 11;
BEGIN
	FOR I IN 1.. 40 LOOP
	insert into person(id, name, company_id) VALUES
	(10 + VNUM, 'person' || PERSON, 2);
	
	VNUM := VNUM + 1;
	PERSON := PERSON + 1;
	
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
VNUM INTEGER := 1;
PERSON INTEGER := 51;
BEGIN
	FOR I IN 1.. 7 LOOP
	insert into person(id, name, company_id) VALUES
	(50 + VNUM, 'person' || PERSON, 3);
	
	VNUM := VNUM + 1;
	PERSON := PERSON + 1;
	
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
VNUM INTEGER := 1;
PERSON INTEGER := 58;
BEGIN
	FOR I IN 1.. 7 LOOP
	insert into person(id, name, company_id) VALUES
	(57 + VNUM, 'person' || PERSON, 4);
	
	VNUM := VNUM + 1;
	PERSON := PERSON + 1;
	
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
VNUM INTEGER := 1;
PERSON INTEGER := 65;
BEGIN
	FOR I IN 1..4 LOOP
	insert into person(id, name, company_id) VALUES
	(64 + VNUM, 'person' || PERSON, 5);
	
	VNUM := VNUM + 1;
	PERSON := PERSON + 1;
	
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
VNUM INTEGER := 1;
PERSON INTEGER := 68;
BEGIN
	FOR I IN 1..4 LOOP
	insert into person(id, name, company_id) VALUES
	(68 + VNUM, 'person' || PERSON, 6);
	
	VNUM := VNUM + 1;
	PERSON := PERSON + 1;
	
	END LOOP;
END;
$$;

DO
$$
DECLARE
I record;
VNUM INTEGER := 1;
PERSON INTEGER := 72;
BEGIN
	FOR I IN 1.. 40 LOOP
	insert into person(id, name, company_id) VALUES
	(72 + VNUM, 'person' || PERSON, 7);
	
	VNUM := VNUM + 1;
	PERSON := PERSON + 1;
	
	END LOOP;
END;
$$;

SELECT p.name person_name, c.name company_name
FROM person p
	JOIN company c ON p.company_id = c.id
WHERE c.id != 5;

SELECT t1.name, quantity_of_persons
FROM (SELECT c.name, COUNT(p.id) quantity_of_persons
		FROM person p 
			JOIN company c ON p.company_id = c.id
		GROUP BY c.name) t1
GROUP BY t1.name, quantity_of_persons
HAVING MAX(quantity_of_persons) = (SELECT COUNT(p.id) quantity_of_persons
									from person p 
										JOIN company c ON p.company_id = c.id
									GROUP BY c.name
								  	ORDER BY COUNT(p.id) DESC
								  	LIMIT 1);


 
	

