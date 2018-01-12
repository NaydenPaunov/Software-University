package books.services.api;

import books.entities.Book;
import books.entities.ReduceBookDTO;
import books.enums.AgeRestriction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.text.ParseException;
import java.util.List;

public interface BookService {

    void createAll(List<Book> books);

    List<Book> getAllBooksAfter2000Year();

    List<String> getBooksFromGeorgePowell();

    List<String> getAllAuthorsWithBooksBefore1990();

    List<String> getAllAuthorsNamesByNumberOfBooks();

    List<Book> getAllBooksByAgeRestriction(String input);

    List<Book> getAllByEditionTypeGoldAndCopiesLessThan(int copies);

    List<Book> getAllByPriceGreaterThanAndPriceLessThan(double greaterThan,double lessThan);

    List<Book> getAllBooksWithReleaseDateNotIn(String year);

    List<Book> getAllByDateBefore(String date) throws ParseException;

    List<Book> getAllByTitleContains(String contains);

    List<Book> getAllByAuthorFirstName(String contains);

    Integer getTitleLenghtIsLongerThan(int number);

    List<String> getCountOfBookCopiesForEachAuthor();

    ReduceBookDTO getInformationForBookByGivenTitle(String title);

    void increaseBookCopiesAfterDate(String inputDate,int num) throws ParseException;

    public void deleteBooks(int num);
}
