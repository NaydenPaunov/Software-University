USE camp;

/* exr 1 */

	CREATE TABLE `Mountains` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20)
	);

	CREATE TABLE `Peaks`(
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50),
		mountain_id INT
	);

	ALTER TABLE peaks
	ADD CONSTRAINT fk_mountain_peaks FOREIGN KEY(mountain_id)
	REFERENCES mountains(id);

/* exr 2 */

	CREATE TABLE authors(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
	);

	CREATE TABLE books(
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50),
		author_id INT,
		CONSTRAINT fk_auhor_id FOREIGN KEY(author_id)
		REFERENCES authors(id)
		ON DELETE CASCADE
	);
	
/* exr 3 */

	SELECT driver_id , vehicle_type , CONCAT(first_name, ' ', last_name) AS `driver_name` FROM vehicles AS v
	JOIN campers AS c ON v.driver_id = c.id;

/* exr 4 */
	
	SELECT starting_point AS `route_starting_point` ,end_point AS `route_ending_point` ,
	leader_id, CONCAT(first_name , ' ',last_name) AS `leader_name` FROM routes AS r
	JOIN campers AS c ON r.leader_id = c.id;
	
/* exr 5 */

	CREATE DATABASE test ;
	USE test;

	CREATE TABLE employees (
		id INT(11) PRIMARY KEY AUTO_INCREMENT,
		first_name VARCHAR(30) NOT NULL,
		last_name VARCHAR(30),
		project_id INT(11)
	);

	CREATE TABLE projects (
		id INT(11) PRIMARY KEY AUTO_INCREMENT,
		client_id INT(11),
		project_lead_id INT(11)
	);

	CREATE TABLE clients(
		id INT(11) PRIMARY KEY AUTO_INCREMENT,
		client_name VARCHAR(100),
		project_id INT(11)
	);

	ALTER TABLE clients
	ADD CONSTRAINT fk_client_project_id FOREIGN KEY(project_id)
	REFERENCES projects(id);

	ALTER TABLE projects
	ADD CONSTRAINT fk_client_id FOREIGN KEY(client_id)
	REFERENCES clients(id),
	ADD CONSTRAINT fk_project_lead_id  FOREIGN KEY(project_lead_id)
	REFERENCES employees(id);

	ALTER TABLE employees
	ADD CONSTRAINT fk_project_id FOREIGN KEY(project_id)
	REFERENCES projects(id);



