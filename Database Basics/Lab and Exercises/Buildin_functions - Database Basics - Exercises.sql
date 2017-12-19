/*USE soft_uni;*/

/* exr 1 */
/*
SELECT first_name,last_name FROM employees 
WHERE SUBSTRING(first_name,1,2) = 'Sa';
*/

/* exr 2 */
/*
SELECT first_name,last_name FROM employees 
WHERE last_name LIKE '%ei%' ORDER BY employee_id;
*/

/* exr 3 */
/*
SELECT first_name FROM employees
WHERE department_id IN(3,10) AND YEAR(hire_date) BETWEEN 1995 AND 2005;
*/
/* exr 4*/
/*
SELECT first_name , last_name FROM employees
WHERE job_title NOT LIKE '%engineer%' ORDER BY employee_id;
*/

/* exr 5*/
/*
SELECT name FROM towns 
WHERE CHAR_LENGTH(name) IN(5,6) ORDER BY name;
*/

/* exr 6*/
/*
SELECT town_id,name FROM towns
WHERE LEFT(name,1) IN ('M','B','E','K') ORDER BY name;
*/

/* exr 7*/
/*
	SELECT town_id,name FROM towns
	WHERE LEFT(name,1) NOT IN ('R','B','D') ORDER BY name;
*/

/* exr 8*/
/*
	CREATE VIEW `v_employees_hired_after_2000` AS
	SELECT first_name,last_name FROM employees 
	WHERE YEAR(hire_date) > 2000;
 
  SELECT * FROM v_employees_hired_after_2000 ;	
*/

/* exr 9 */
/*
SELECT first_name, last_name FROM employees
WHERE LENGTH(last_name) = 5;
*/

/*USE geography;*/

/* exr 10 */
/*
SELECT country_name , iso_code FROM countries
WHERE country_name LIKE '%A%A%A%' ORDER BY iso_code;
*/


/* exr 11 */
/*
SELECT peak_name,river_name,LOWER(CONCAT(peak_name,LOWER(SUBSTRING(river_name,2)))) AS `mix`
FROM peaks AS p ,	rivers AS r
WHERE RIGHT(p.peak_name,1) = LEFT (r.river_name,1) ORDER BY mix;
*/

/* USE diablo */
/* exr 12 */
/*
SELECT `name` , date_format(`start`,'%Y-%m-%d') AS `start` FROM games AS g 
WHERE YEAR(`start`) >= 2011 AND YEAR(`start`) <= 2012 ORDER BY `start`,name LIMIT 50;
*/

/* exr 13 */
/*
SELECT user_name,SUBSTRING_INDEX(email,'@',-1) AS 'Email Provider' FROM users
ORDER BY `Email Provider`,`user_name`;
*/

/* exr 14 */
/*
SELECT user_name,ip_address FROM users AS `u`
WHERE u.ip_address LIKE '___.1%.%.___' ORDER BY user_name,ip_address;
*/

/* exr 15 */
/*
SELECT name AS `Game`,
CASE
WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
WHEN HOUR(`start`) BETWEEN 18 AND 23 THEN 'Evening'
END AS `Part of the Day`,

CASE
WHEN duration <= 3 THEN 'Extra Short'
WHEN duration > 3 AND duration <= 6 THEN 'Short'
WHEN duration > 6 AND duration <= 10 THEN 'Long'
ELSE 'Extra Long'
END AS `Duration`
FROM games;
*/

/* exr 16 */
/*
SELECT product_name,order_date,ADDDATE(order_date, INTERVAL 3 DAY) AS `pay_due`,
ADDDATE(order_date, INTERVAL 1 MONTH) AS `deliver_due` FROM orders;
*/



