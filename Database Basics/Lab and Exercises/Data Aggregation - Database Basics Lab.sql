/* USE restaurant; */

/* exr 1 */ 
/*
	SELECT department_id, COUNT(id) AS 'Number of employees' FROM employees
	GROUP BY department_id;
*/

/* exr 2 */
/*
	SELECT department_id, ROUND(AVG(salary),2) AS 'Average Salary' FROM employees
	GROUP BY department_id;
*/

/* exr 3 */
/*
SELECT department_id, ROUND(MIN(salary),2) AS 'Min salary' FROM employees AS e
GROUP BY e.department_id
HAVING `Min salary` > 800;
*/

/* exr 4 */
/*
SELECT COUNT(id) FROM products AS p
WHERE p.price > 8  AND p.category_id = 2 
GROUP BY p.category_id;
*/

/* exr 5 */
/*
SELECT category_id, 
ROUND(AVG(price),2) AS 'Average Price' , 
ROUND(MIN(price),2) AS 'Cheapest Product', 
ROUND(MAX(price),2) AS 'Most Expensive Product' 
FROM products AS p
GROUP BY p.category_id;
*/