package books.repositories;

import books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;



public interface BookRepository extends JpaRepository<Book,Long> {

    @Query(value = "SELECT * FROM book AS b WHERE year(b.release_date) > 2000;" , nativeQuery = true)
    List<Book> getBooksByReleaseDateAfter2000();

    @Query(value = "SELECT concat_ws(' - ', b.title,b.realease_date, b.copies)\n" +
            "FROM book AS b\n" +
            "INNER JOIN author AS a \n" +
            "\tON b.author_id = a.author_id\n" +
            "\tAND CONCAT_WS(' ', a.first_name, a.last_name) = 'George Powell'\n" +
            " ORDER BY b.release_date DESC, b.title;" , nativeQuery = true)
    List<String> getBooksFromGeorgePowell();

    @Query(value = "\n" +
            "SELECT CONCAT(a.first_name ,' ',a.last_name) FROM author AS a\n" +
            "INNER JOIN book AS b ON a.author_id = b.author_id\n" +
            "WHERE year(b.release_date) > 1990\n" +
            "GROUP BY a.author_id;", nativeQuery = true)
    List<String> getAllAuthorsWithBooksBefore1990();

    @Query(value = "SELECT CONCAT(a.first_name,' ',a.last_name) AS name FROM author AS a\n" +
            "INNER JOIN book AS b\n" +
            "ON a.author_id = b.author_id \n" +
            "GROUP BY a.author_id\n" +
            "ORDER BY COUNT(b.book_id);" , nativeQuery = true)
    List<String> getAllAuthorsNamesByNumberOfBooks();

}
