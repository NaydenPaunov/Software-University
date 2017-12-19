USE book_library;
/* ----------------------- LAB --------------------------------------*/
/* exr 1 */
/*
SELECT title FROM BOOKS
WHERE SUBSTRING(title,1,3) = 'The'
ORDER BY id;
*/

/* exr 2 */ 
/*
SELECT REPLACE(title,'The','***') FROM BOOKS
WHERE SUBSTRING(title,1,3) = 'The'
ORDER BY id;
*/
/* exr 3 */ 
/*
SELECT SUM(cost) FROM books;
*/
/* exr 4 */ 
/*
SELECT CONCAT(first_name,' ',last_name) AS 'Full Name', TIMESTAMPDIFF(DAY,born , died) AS 'Days Lived' FROM authors;
*/
/* exr 5 */
/*
SELECT title FROM books
WHERE title LIKE 'Harry Potter%';
*/





