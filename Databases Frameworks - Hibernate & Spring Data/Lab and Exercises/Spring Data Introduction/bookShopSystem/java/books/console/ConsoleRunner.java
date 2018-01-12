package books.console;

import books.entities.Author;
import books.entities.Book;
import books.entities.Category;
import books.services.api.AuthorService;
import books.services.api.BookService;
import books.services.api.CategoryService;
import books.utilities.ReadAuthorFile;
import books.utilities.ReadBooksFile;
import books.utilities.ReadCategoryFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final String CATEGORY_FILE_PATH = "D:\\Na4oy\\springDataIntroExr\\src\\main\\resources\\files\\categories.txt";
    private static final String AUTHOR_FILE_PATH = "D:\\Na4oy\\springDataIntroExr\\src\\main\\resources\\files\\authors.txt";
    private static final String BOOKS_FILE_PATH = "D:\\Na4oy\\springDataIntroExr\\src\\main\\resources\\files\\books.txt";
    private ReadBooksFile readBooksFile;
    private ReadAuthorFile readAuthorFile;
    private ReadCategoryFile readCategoryFile;
    private CategoryService categoryService;
    private AuthorService authorService;
    private BookService bookService;


    @Autowired
    public ConsoleRunner(ReadBooksFile readBooksFile, ReadAuthorFile readAuthorFile,
                         ReadCategoryFile readCategoryFile, CategoryService categoryService,
                         AuthorService authorService, BookService bookService) {
        this.readBooksFile = readBooksFile;
        this.readAuthorFile = readAuthorFile;
        this.readCategoryFile = readCategoryFile;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        List<Category> categories =
//                this.readCategoryFile.read(CATEGORY_FILE_PATH);
//        List<Author> authors =
//                this.readAuthorFile.read(AUTHOR_FILE_PATH);
//        List<Book> books =
//              this.readBooksFile.read(BOOKS_FILE_PATH);
//
//        this.categoryService.createAll(categories);
//        this.authorService.createAll(authors);
//        this.bookService.createAll(books);

//        printTitleOfBooks(this.bookService.getAllBooksAfter2000Year());

//        printBooksFromGeorgePowell(this.bookService.getBooksFromGeorgePowell());

//        printAllAuthorsWithBooksBefore1990(this.bookService.getAllAuthorsWithBooksBefore1990());

        printAllAuthorsWithBooksBefore1990(this.bookService.getAllAuthorsNamesByNumberOfBooks());


    }

    private void printAllAuthorsWithBooksBefore1990(List<String> books) {
        books.forEach(System.out::println);
    }


    private void printBooksFromGeorgePowell(List<String> books) {
        books.forEach(System.out::println);
    }

    private void printTitleOfBooks(List<Book> books) {
        books.stream().map(Book::getTitle).forEach(System.out::println);
    }
}
