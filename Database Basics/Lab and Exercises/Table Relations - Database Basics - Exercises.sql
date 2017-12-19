/* exr 1 */ 

CREATE TABLE persons(
	person_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
	salary DECIMAL(8,2) NOT NULL,
	passport_id INT UNIQUE
);

CREATE TABLE passports(
	passport_id INT PRIMARY KEY ,
	passport_number VARCHAR(20) NOT NULL
);

ALTER TABLE persons
ADD CONSTRAINT fk_person_passport_id FOREIGN KEY(passport_id)
REFERENCES passports(passport_id);

INSERT INTO passports(passport_id,passport_number) VALUES (101,'N34FG21B');
INSERT INTO passports(passport_id,passport_number) VALUES (102,'K65LO4R7');
INSERT INTO passports(passport_id,passport_number) VALUES (103,'ZE657QP2');

INSERT INTO persons (first_name,salary,passport_id) VALUES ('Roberto',43300.00,102);
INSERT INTO persons (first_name,salary,passport_id) VALUES ('Tom',56100.00,103);
INSERT INTO persons (first_name,salary,passport_id) VALUES ('Yana', 60200.00,101);

/* exr 2 */

CREATE TABLE manufacturers(
	manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
	established_on DATETIME
);

CREATE TABLE models(
	model_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
	manufacturer_id INT,
	CONSTRAINT fk_manufacturer_id
	FOREIGN KEY (manufacturer_id)	REFERENCES manufacturers(manufacturer_id)
);

INSERT INTO manufacturers (name,established_on) VALUES ('BMW','1916-03-01 00:00:00');
INSERT INTO manufacturers (name,established_on) VALUES ('Tesla','2003-01-01 00:00:00');
INSERT INTO manufacturers (name,established_on) VALUES ('Lada','1966-05-01 00:00:00');

INSERT INTO models(model_id,name,manufacturer_id)  VALUES (101,'X1',1);
INSERT INTO models(model_id,name,manufacturer_id)  VALUES (102,'i6',1);
INSERT INTO models(model_id,name,manufacturer_id)  VALUES (103,'Model S',2);
INSERT INTO models(model_id,name,manufacturer_id)  VALUES (104,'Model X',2);
INSERT INTO models(model_id,name,manufacturer_id)  VALUES (105,'Model 3',2);
INSERT INTO models(model_id,name,manufacturer_id)  VALUES (106,'Nova',3);

/* exr 3 */


CREATE TABLE students(
	student_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20)
);

CREATE TABLE exams(
	exam_id INT  PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20)
);

CREATE TABLE students_exams(
	student_id INT,
	exam_id INT,
	CONSTRAINT pk_students_exams_id 
	PRIMARY KEY (student_id,exam_id),
	CONSTRAINT fk_student_id FOREIGN KEY(student_id) REFERENCES students(student_id),
   CONSTRAINT fk_exam_id FOREIGN KEY(exam_id) REFERENCES exams(exam_id)
);

INSERT INTO students(name) VALUES ('Mila'),('Toni'),('Ron');
INSERT INTO exams(exam_id,name) VALUES (101,'Spring MVC'),(102,'Neo4j'),(103,'Oracle 11g');
INSERT INTO students_exams (student_id,exam_id) VALUES (1,101),(1,102),(2,101),(3,103),(2,102),(2,103);

/* exr 4 */

 CREATE TABLE teachers(
 teacher_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(20),
 manager_id INT,
 CONSTRAINT fk_teacher_id
 FOREIGN KEY(manager_id) REFERENCES teachers(teacher_id)
 );
 
 INSERT INTO teachers(teacher_id,name) VALUES (101,'John');	
 INSERT INTO teachers(teacher_id,name) VALUES (102,'Maya');
 INSERT INTO teachers(teacher_id,name) VALUES (103,'Silvia');
 INSERT INTO teachers(teacher_id,name) VALUES (104,'Ted');
 INSERT INTO teachers(teacher_id,name) VALUES (105,'Mark');
 INSERT INTO teachers(teacher_id,name) VALUES (106,'Greta');
     
 UPDATE teachers SET manager_id = 106
 WHERE teacher_id = 102;
 
 UPDATE teachers SET manager_id = 106
 WHERE teacher_id = 103;
 
 UPDATE teachers SET manager_id = 105
 WHERE teacher_id = 104;
 
 UPDATE teachers SET manager_id = 101
 WHERE teacher_id = 105;
 
 UPDATE teachers SET manager_id = 101
 WHERE teacher_id = 106;
 
 /* exr 5 */
 
 CREATE TABLE item_types(
	item_type_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

CREATE TABLE items (
	item_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
	item_type_id INT(11),
	CONSTRAINT fk_item_type_id
	FOREIGN KEY(item_type_id) REFERENCES item_types(item_type_id)
);

CREATE TABLE cities(
	city_id  INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

CREATE TABLE customers(
	customer_id  INT(11) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50),
	birthday DATE,
	city_id INT(11),
	CONSTRAINT fk_city_id 
	FOREIGN KEY(city_id) REFERENCES cities(city_id)
);

CREATE TABLE orders(
	order_id INT(11) PRIMARY KEY AUTO_INCREMENT,
	customer_id INT(11),
	CONSTRAINT fk_customer_id 
	FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE order_items(
	order_id INT,
	item_id INT,
	CONSTRAINT pk_order_item PRIMARY KEY(order_id,item_id),
	CONSTRAINT fk_order_id FOREIGN KEY(order_id) REFERENCES orders(order_id),
	CONSTRAINT fk_item_id FOREIGN KEY(item_id) REFERENCES items(item_id)
);

/* exr 6 */

CREATE TABLE subjects(
	subject_id INT PRIMARY KEY AUTO_INCREMENT,
	subject_name VARCHAR(50)
);

CREATE TABLE majors(
	major_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50)
);

CREATE TABLE students(
	student_id INT PRIMARY KEY AUTO_INCREMENT,
	student_number VARCHAR(12),
	student_name VARCHAR(50),
	major_id INT,
	CONSTRAINT fk_major_id FOREIGN KEY(major_id) REFERENCES majors(major_id)
);

CREATE TABLE payments(
	payment_id  INT PRIMARY KEY AUTO_INCREMENT,
	payment_date DATE,
	payment_amount DECIMAL(8,2),
	student_id INT,
	CONSTRAINT fk_student_id FOREIGN KEY(student_id) REFERENCES students(student_id)
);

CREATE TABLE agenda(
	student_id INT,
	subject_id INT,
	CONSTRAINT pk_agenda PRIMARY KEY(student_id, subject_id),
	CONSTRAINT fk_agenda_student_id FOREIGN KEY(student_id) REFERENCES students(student_id),
	CONSTRAINT fk_agenda_subject_id FOREIGN KEY(subject_id) REFERENCES subjects(subject_id)
);

/* exr 9 */ 


SELECT m.mountain_range, p.peak_name, p.elevation FROM mountains AS m
JOIN peaks AS p
ON p.mountain_id = m.id
WHERE m.mountain_range = 'Rila'
ORDER BY p.elevation DESC;