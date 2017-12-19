/* exr 1 */ 

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DOUBLE)
RETURNS INTEGER
BEGIN
	DECLARE town_count INTEGER;
	
	SET town_count = (SELECT COUNT(`first_name`)
							FROM employees AS e
							JOIN addresses AS a ON e.address_id = a.address_id
							JOIN towns AS t ON t.town_id = a.town_id
							WHERE t.name = town_name);
							
	RETURN town_count;						
END $$

SELECT ufn_count_employees_by_town('Sofia') AS `count`

/* exr 2 */ 

DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(20))
BEGIN
	UPDATE employees AS e
	SET salary = salary + 0.05*salary
	WHERE e.department_id = (SELECT department_id FROM departments WHERE name = department_name);
	
END $$

CALL usp_raise_salaries('Tool Design');

/* exr 3 */ 

DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INTEGER)
BEGIN
	UPDATE employees AS e
	SET salary = salary + 0.05*salary
	WHERE e.employee_id = id;
	
END $$

/* exr 4 */ 

CREATE TABLE deleted_employees(
	employee_id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	middle_name VARCHAR(20),
	job_title VARCHAR(50),
	department_id INT,
	salary DOUBLE 
);

DELIMITER $$
CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO deleted_employees     (first_name,last_name,middle_name,job_title,department_id,salary)
	VALUES(OLD.first_name,OLD.last_name,OLD.middle_name,OLD.job_title,OLD.department_id,OLD.salary);
END $$