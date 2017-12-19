 USE gringotts;

/* exr 1 */

	SELECT COUNT(id) AS 'count' FROM wizzard_deposits AS wd;

/* exr 2 */

	SELECT MAX(magic_wand_size) FROM wizzard_deposits;
	
/* exr 3 */

	SELECT deposit_group, MAX(magic_wand_size) AS 'longest_magic_wand' FROM wizzard_deposits AS wp
	GROUP BY wp.deposit_group ORDER BY longest_magic_wand , wp.deposit_group;	

/* exr 4 */	

	SELECT deposit_group
	FROM wizzard_deposits AS wp
	GROUP BY wp.deposit_group
	ORDER BY AVG(magic_wand_size) LIMIT 1 ;	

/* exr 5 */

	SELECT deposit_group, SUM(deposit_amount) AS 'Total Sum'
	FROM wizzard_deposits AS wd
	GROUP BY wd.deposit_group
	ORDER BY `Total Sum`;

/* exr 6 */

 	SELECT deposit_group, SUM(deposit_amount) AS 'total_sum'
	FROM wizzard_deposits AS wd
	WHERE wd.magic_wand_creator = 'Ollivander family'
	GROUP BY wd.deposit_group
	ORDER BY wd.deposit_group;
	
/* exr 7 */
	
	SELECT deposit_group, SUM(deposit_amount) AS 'total_sum'
	FROM wizzard_deposits AS wd
	WHERE wd.magic_wand_creator = 'Ollivander family'
	GROUP BY wd.deposit_group
	HAVING `total_sum` < 150000
	ORDER BY `total_sum` DESC;
	
/* exr 8 */
	
	SELECT deposit_group, magic_wand_creator,MIN(deposit_charge)
	FROM wizzard_deposits AS wd
	GROUP BY magic_wand_creator, deposit_group ;
	
/* exr 9 */

 SELECT
 	CASE
 		WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
 		WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
 		WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
 		WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
 		WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
 		WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
		WHEN `age` > 60 THEN '[61+]'
	END AS `age_group` ,
	COUNT(*) AS `wizard_count`
	FROM wizzard_deposits AS wd
	GROUP BY `age_group`;

/* exr 10 */
	
	SELECT DISTINCT LEFT(first_name,1) AS 'first_letter'
	FROM wizzard_deposits AS wd
	WHERE deposit_group = 'Troll Chest'
	GROUP BY `first_letter`;
	
/* exr 11 */
	SELECT deposit_group, is_deposit_expired, AVG(deposit_interest) AS 'average_interest'
	FROM wizzard_deposits AS wd
	WHERE wd.deposit_start_date > '1985-01-01'
	GROUP BY is_deposit_expired,deposit_group
	ORDER BY deposit_group DESC,is_deposit_expired ASC;
	
/* exr 12 */ 

  /* IN PROGRESS */
  
/* exr 13 */

	SELECT department_id,  MIN(salary) AS 'minimum_salary' FROM employees AS e
	WHERE e.department_id IN(2,5,7) AND e.hire_date > '2000-01-01'
	GROUP BY e.department_id
	ORDER BY e.department_id ASC;

/* exr 14 */

	 	CREATE TEMPORARY TABLE IF NOT EXISTS `emp` AS (
		SELECT * FROM employees AS `e`
		WHERE e.salary > 30000);
	
	DELETE FROM `emp` WHERE manager_id = 42;
	
	UPDATE `emp`
	SET salary = salary + 5000
	WHERE department_id = 1;
	
	SELECT department_id, AVG(salary) FROM `emp`
	GROUP BY department_id;

/* exr 15 */

	SELECT department_id , MAX(salary) AS 'max_salary' FROM employees AS e
 	GROUP BY department_id
 	HAVING `max_salary` NOT BETWEEN 30000 AND 70000;
 	

/* exr 16 */

	SELECT COUNT(salary) FROM employees AS e
	WHERE manager_id IS NULL;
	
/* exr 17 */

  /* IN PROGRESS */
	
/* exr 18 */
	
	SELECT em.first_name, em.last_name, em.department_id
	FROM employees AS em
	JOIN
	(SELECT e.department_id, AVG(e.salary) AS avg_salary
	FROM employees AS e
	GROUP BY e.department_id) AS avg_salaries
	ON em.department_id = avg_salaries.department_id
	WHERE em.salary > avg_salaries.avg_salary
	ORDER BY em.department_id
	LIMIT 10;
	
/* exr 19 */

SELECT department_id , SUM(salary) AS  `total_salary` FROM employees AS `e`
GROUP BY e.department_id;
	
	
	