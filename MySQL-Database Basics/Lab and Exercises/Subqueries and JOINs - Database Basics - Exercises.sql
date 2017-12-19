USE soft_uni;

/* exr 1 */

SELECT e.employee_id, e.job_title, e.address_id , address_text FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
ORDER BY e.address_id LIMIT 5;

/* exr 2 */

SELECT e.first_name, e.last_name, t.name , a.address_text FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
JOIN towns AS t ON t.town_id = a.town_id
ORDER BY e.first_name ASC,e.last_name LIMIT 5;

/* exr 3 */

SELECT e.employee_id ,e.first_name, e.last_name, d.name FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;

/* exr 4 */

SELECT e.employee_id ,e.first_name, e.salary, d.name FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC LIMIT 5;

/* exr 5 */

SELECT e.employee_id ,e.first_name FROM employees AS e
LEFT JOIN employees_projects AS ep ON ep.employee_id = e.employee_id
WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC LIMIT 3;

/* exr 6 */

SELECT e.first_name,e.last_name,e.hire_date,d.name AS dept_name FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id AND (d.name = "Sales" OR d.name = "Finance")
WHERE e.hire_date >= '1999-01-02 00:00:00.000000'
ORDER BY e.hire_date ;

/* exr 7 */

SELECT  e.employee_id,e.first_name,p.name FROM employees AS e
JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
JOIN projects AS p ON ep.project_id = p.project_id AND p.end_date IS NULL
WHERE p.start_date >= '2002-08-14 00:00:00.000000'
ORDER BY e.first_name ASC,p.name ASC LIMIT 5;

/* exr 8 */

SELECT e.employee_id,e.first_name,
IF(start_date >= '2005-01-01',NULL,`name`) AS `project_name` 
FROM employees AS e
JOIN employees_projects AS ep ON e.employee_id = ep.employee_id 
JOIN projects AS p ON p.project_id = ep.project_id
WHERE e.employee_id = 24
ORDER BY `project_name`;

/* exr 9 */

SELECT e.employee_id,e.first_name,e.manager_id,
IF(e.manager_id = 3,
(SELECT first_name FROM employees  AS ee WHERE ee.employee_id = 3),
(SELECT first_name FROM employees  AS eee WHERE eee.employee_id = 7))  
FROM employees AS e
WHERE manager_id IN(3,7)
ORDER BY e.first_name;

/* exr 10 */

SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
CONCAT(m.first_name, ' ', m.last_name) AS manager_name, d.name
FROM employees AS e 
    JOIN employees AS m ON e.manager_id = m.employee_id
	JOIN departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;

/* exr 11 */ 

SELECT AVG(salary)AS Min_salary FROM employees AS e
GROUP BY e.department_id
ORDER BY Min_salary LIMIT 1 ;

/* exr 12 */
USE geography ; 

SELECT mc.country_code,m.mountain_range,p.peak_name,p.elevation FROM peaks AS p
JOIN mountains_countries AS mc ON mc.mountain_id = p.mountain_id
JOIN mountains AS m ON m.id = mc.mountain_id
WHERE mc.country_code = 'BG' AND p.elevation > 2835
ORDER BY p.elevation DESC;

/* exr 13 */

SELECT country_code,COUNT(mountain_id) AS `mountain_range` FROM mountains_countries
WHERE country_code IN('BG','RU','US')
GROUP BY country_code
ORDER BY mountain_range DESC;

/* exr 14 */

SELECT country_name, r.river_name FROM countries AS cou
JOIN continents AS con ON cou.continent_code = con.continent_code AND con.continent_name = 'Africa'
LEFT JOIN countries_rivers AS cr ON cr	.country_code = cou.country_code
LEFT JOIN rivers AS r ON cr.river_id = r.id
ORDER BY cou.country_name ASC LIMIT 5;

/* exr 15 */

SELECT c.continent_code , c.currency_code, COUNT(c.country_name) AS currency_usage  
FROM countries AS c
GROUP BY c.continent_code, c.currency_code
HAVING currency_usage = (
	SELECT COUNT(country_code) AS `count` 
	FROM countries AS `c1`
	WHERE `c1`.`continent_code` = c.continent_code
	GROUP BY currency_code
	ORDER BY `count` DESC
	LIMIT 1
 ) AND `currency_usage` > 1
ORDER BY continent_code, c.currency_code ;

/* exr 16 */

SELECT COUNT(c.country_code) AS count FROM countries AS c
LEFT JOIN mountains_countries AS mc ON mc.country_code = c.country_code
WHERE mc.mountain_id IS NULL;

/* exr 17 */

SELECT c.country_name ,MAX(p.elevation) AS highest_peak_elevation,MAX(r.length) AS longest_river_length FROM countries AS c
JOIN mountains_countries AS mc ON mc.country_code = c.country_code
JOIN peaks AS p ON mc.mountain_id = p.mountain_id
JOIN countries_rivers AS cr ON cr.country_code = c.country_code
JOIN rivers AS r ON r.id = cr.river_id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC,longest_river_length DESC,c.country_name LIMIT 5;