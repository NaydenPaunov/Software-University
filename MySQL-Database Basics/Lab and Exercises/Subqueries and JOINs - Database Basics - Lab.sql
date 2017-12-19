USE soft_uni;

/* exr 1 */

SELECT e.employee_id,
CONCAT(e.first_name,' ',e.last_name) AS `full_name` ,
d.department_id,d.name FROM employees AS e
JOIN departments AS d ON d.manager_id = e.employee_id
ORDER BY e.employee_id LIMIT 5;

/* exr 2 */

SELECT a.town_id,t.name,a.address_text FROM addresses AS a
JOIN towns AS t ON a.town_id = t.town_id
WHERE t.name IN('San Francisco','Sofia','Carnation')
ORDER BY a.town_id,a.address_text;

/* exr 3 */

SELECT employee_id, first_name, last_name, department_id, salary FROM employees
WHERE manager_id IS NULL;

/* exr 4 */

SELECT COUNT(salary) FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);