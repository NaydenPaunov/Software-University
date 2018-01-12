package books.services.api;

import books.entities.Book;

import java.util.List;

public interface BookService {

    void createAll(List<Book> books);

    List<Book> getAllBooksAfter2000Year();

    List<String> getBooksFromGeorgePowell();

    List<String> getAllAuthorsWithBooksBefore1990();

    List<String> getAllAuthorsNamesByNumberOfBooks();
}
