CREATE TABLE task_type(
	id integer NOT NULL PRIMARY KEY,
	type varchar(20) NOT NULL,
	comment varchar(50) DEFAULT NULL
);

CREATE TABLE task(
	id serial NOT NULL PRIMARY KEY,
	user_id integer NOT NULL,
	type_id integer NOT NULL,
	title varchar(50) NOT NULL,
	detail text,
	deadline timestamp NOT NULL
);
