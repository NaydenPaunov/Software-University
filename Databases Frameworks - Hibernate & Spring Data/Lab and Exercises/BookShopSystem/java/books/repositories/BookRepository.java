package books.repositories;

import books.entities.Book;
import books.entities.ReduceBookDTO;
import books.enums.AgeRestriction;
import books.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.xml.crypto.Data;
import java.util.Date;
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

    List<Book> findAllByAgeRestriction(Integer ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(int editionType, int copies);

    List<Book> findAllByPriceGreaterThanAndPriceLessThan(double greaterThan,double lessThan);

    @Query("SELECT b FROM Book b WHERE SUBSTRING(b.releaseDate,1 ,4) NOT LIKE :year ")
    List<Book> findByReleaseDateNot(@Param("year") String year);

    List<Book> findAllByReleaseDateBefore(Date date);

    List<Book> findAllByTitleContains(String contains);

    @Query("SELECT b FROM Book b WHERE b.author.lastName LIKE :contains")
    List<Book> findAllByAuthorFirstName(@Param("contains") String contains);

    @Query("SELECT count(b) FROM Book as b WHERE length(b.title) > :number ")
    Integer findAllByTitleLenghtLongerThan(@Param("number") int number);

    @Query("SELECT CONCAT(b.author.firstName, ' ' ,b.author.lastName, ' - ' , sum(b.copies)) " +
            "FROM Book b group by b.author ORDER BY sum(b.copies) DESC ")
    List<String> findCountOfBookCopiesForEachAuthor();

//    @Query("SELECT CONCAT(b.title,' ',b.editionType,' ',b.ageRestriction,' ',b.price) FROM Book b" +
//            " WHERE b.title LIKE :givenTitle")
    @Query("SELECT new books.entities.ReduceBookDTO(b.title,b.editionType,b.ageRestriction,b.price) FROM Book b" +
            " WHERE b.title LIKE :givenTitle")
    ReduceBookDTO findInformationForBookByGivenTitle(@Param("givenTitle") String title);

    List<Book> findAllByReleaseDateAfter(Date releaseDate);

    @Query("UPDATE Book b SET b.copies = b.copies + :num WHERE b.bookId = :id ")
    @Modifying
    void increaseCopies(@Param("id")Long id, @Param("num")int num);

    List<Book> findAllByCopiesLessThan(int copies);

    @Query("DELETE FROM Book b WHERE b.copies < :copies")
    @Modifying
    void deleteWithCopiesLowerThan(@Param("copies") int num);
}
