package books.services.impl;

import books.entities.Book;
import books.repositories.BookRepository;
import books.services.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void createAll(List<Book> books) {
        this.bookRepository.save(books);
    }

    @Override
    public List<Book> getAllBooksAfter2000Year() {
        return this.bookRepository.getBooksByReleaseDateAfter2000();
    }

    @Override
    public List<String> getBooksFromGeorgePowell() {
        return this.bookRepository.getBooksFromGeorgePowell();
    }

    @Override
    public List<String> getAllAuthorsWithBooksBefore1990() {
        return this.bookRepository.getAllAuthorsWithBooksBefore1990();
    }

    @Override
    public List<String> getAllAuthorsNamesByNumberOfBooks() {
        return this.bookRepository.getAllAuthorsNamesByNumberOfBooks();
    }
}
