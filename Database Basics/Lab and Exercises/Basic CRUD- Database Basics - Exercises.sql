
 /* exr 1 */
/*
	SELECT * FROM departments ORDER BY department_id;
*/

/* exr 2 */
 /*
	SELECT `name` FROM `departments` ORDER BY `department_id`;
*/

/* exr 3 */
/*
	SELECT first_name,last_name,salary FROM employees ORDER BY employee_id;
*/

/* exr 4*/
/*
 	SELECT first_name,middle_name,last_name FROM employees ORDER BY employee_id;
*/

/* exr 5 */
/*
	CREATE VIEW `v_employee_email` AS
		SELECT CONCAT(first_name,'.', last_name,'@softuni.bg') AS 'full_email_address&quot'
		 FROM employees;	

	SELECT * FROM v_employee_email ;
*/

/* exr 6 */
/*
	 SELECT DISTINCT salary FROM employees ORDER BY employee_id;
*/

/* exr 7 */
/*
	SELECT * FROM employees WHERE job_title = "Sales Representative" ORDER BY employee_id; 
*/

/* exr 8 */
/*
	SELECT first_name, last_name,job_title FROM employees WHERE salary BETWEEN 20000 AND 30000;	
*/

/* exr 9 */
/*
	SELECT CONCAT(first_name,' ',middle_name,' ',last_name) AS 'full_name' FROM employees WHERE salary IN(25000, 14000, 12500, 23600);  
*/

/* exr 10 */
/*
	SELECT first_name , last_name  FROM employees WHERE manager_id IS NULL;
*/

/* exr 11 */
/*
 SELECT first_name , last_name , salary FROM employees WHERE salary > 50000 ORDER BY salary DESC ;
*/

/* exr 12 */	
/*	
	CREATE VIEW `v_employee_salary_descending` AS
		SELECT * FROM employees ORDER BY salary DESC;	

	SELECT first_name , last_name FROM v_employee_salary_descending LIMIT 5 ; 
*/	
	
/* exr 13*/
/*
	 SELECT first_name , last_name FROM employees WHERE department_id != 4;
*/

/* exr 14*/
/*
	SELECT * FROM employees ORDER BY salary DESC,first_name,last_name DESC,middle_name;
*/

/* exr 15*/
/*		
		CREATE VIEW `v_employees_salaries` AS
		SELECT first_name , last_name, salary FROM employees;	

		SELECT * FROM v_employees_salaries  ; 
*/

/* exr 16*/
/*
	CREATE VIEW `v_employees_job_titles` AS 
	SELECT CONCAT(first_name ,' ', IFNULL(middle_name,''),' ', last_name),job_title FROM employees ;
	
	SELECT * FROM v_employees_job_titles;
*/

/* exr 17*/
/*
	SELECT DISTINCT job_title FROM employees;
*/

/* exr 18*/
/*
		SELECT * FROM projects ORDER BY start_date,name,project_id LIMIT 10;
*/

/* exr 19*/
/*
	SELECT first_name, last_name, hire_date FROM employees ORDER BY hire_date DESC LIMIT 7;
*/

/* exr 20*/
/*
	UPDATE employees 
	SET salary = salary + salary*0.12
	WHERE department_id IN(1,2,4,11);
	
	SELECT salary FROM employees;

*/

/* exr 21*/
/*
   USE geography ;
	SELECT peak_name FROM peaks ORDER BY peak_name;
*/

/* exr 22*/
/*
	SELECT country_name , population FROM countries WHERE continent_code = "EU" ORDER BY population DESC,country_name LIMIT 30;
*/

/* exr 23*/
/*	
	SELECT country_name,country_code,
	IF(`currency_code`= 'EUR','Euro','Not Euro') AS 'currency' 
	FROM countries ORDER BY country_name ;
*/
		
/* exr 24 */
 /*
 USE diablo; 
 SELECT name FROM characters ORDER BY name;
*/