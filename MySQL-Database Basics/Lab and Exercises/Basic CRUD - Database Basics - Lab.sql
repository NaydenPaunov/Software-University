USE hospital;

SELECT id, CONCAT(first_name,' ', last_name) AS 'Full Name' , job_title , salary FROM employees WHERE salary > 1000.00 ORDER BY id;


UPDATE employees
SET salary = salary + salary*0.1 
WHERE job_title = "Therapist";

SELECT salary FROM employees ORDER BY salary ASC;


CREATE VIEW `v_top_paid_employee` AS
SELECT * FROM employees ORDER BY salary DESC LIMIT 1 ;

SELECT * FROM `v_top_paid_employee`; 

SELECT * FROM employees WHERE department_id = 4 AND salary >= 1600 ORDER BY id;

DELETE FROM employees WHERE department_id = 1 OR department_id = 2 ;
SELECT * FROM employees ORDER BY id ;