/* exr 1 */
DROP PROCEDURE IF EXISTS usp_get_employees_salary_above_35000;
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
    SELECT `e`.`first_name`, `e`.`last_name` FROM `employees` AS `e`
    WHERE `salary` > 35000
	 ORDER BY `e`.`first_name`,`e`.`last_name`, `e`.`employee_id` ASC;
END$$

CALL usp_get_employees_salary_above_35000();

/* exr 2 */ 

DROP PROCEDURE IF EXISTS usp_get_employees_salary_above;
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_salary_above`(IN `number` DECIMAL(19,4))
BEGIN
    SELECT `e`.`first_name`, `e`.`last_name` FROM `employees` AS `e`
    WHERE `salary` >= `number`
	 ORDER BY `e`.`first_name`,`e`.`last_name`, `e`.`employee_id` ASC;
END$$

CALL usp_get_employees_salary_above();

/* exr 3 */ 

DROP PROCEDURE IF EXISTS usp_get_towns_starting_with;
DELIMITER $$
CREATE PROCEDURE `usp_get_towns_starting_with`(IN `str` VARCHAR(20))
BEGIN
    SELECT name FROM towns
	 WHERE name LIKE CONCAT(str,'%')
	 ORDER BY name;
END$$

CALL usp_get_towns_starting_with('B');

/* exr 4 */ 

DROP PROCEDURE IF EXISTS usp_get_employees_from_town;
DELIMITER $$
CREATE PROCEDURE `usp_get_employees_from_town`(IN `town_name` VARCHAR(20))
BEGIN
    SELECT first_name,last_name FROM employees AS e
    JOIN addresses AS a ON a.address_id = e.address_id
    JOIN towns AS t ON t.town_id = a.town_id
    WHERE t.name = town_name
	 ORDER BY first_name,last_name,employee_id;
END$$

CALL usp_get_employees_from_town('Sofia');

/* exr 5 */

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(e_salary DECIMAL(19,4))
RETURNS VARCHAR(8)
BEGIN
	DECLARE result	 VARCHAR(8);
	
	IF e_salary < 30000 THEN SET result ='Low';
	ELSEIF e_salary >= 30000 AND e_salary <= 50000 THEN SET result = 'Average';
	ELSEIF e_salary > 50000 THEN SET result = 'High';
	END IF;
							
	RETURN `result`;						
END $$

SELECT ufn_get_salary_level(35000) AS `count`
