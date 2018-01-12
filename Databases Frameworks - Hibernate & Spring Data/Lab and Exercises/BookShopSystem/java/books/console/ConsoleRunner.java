package books.console;

import books.entities.Author;
import books.entities.Book;
import books.entities.Category;
import books.entities.ReduceBookDTO;
import books.enums.AgeRestriction;
import books.services.api.AuthorService;
import books.services.api.BookService;
import books.services.api.CategoryService;
import books.utilities.ReadAuthorFile;
import books.utilities.ReadBooksFile;
import books.utilities.ReadCategoryFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final String CATEGORY_FILE_PATH = "D:\\Na4oy\\BookShopSystem\\src\\main\\resources\\files\\categories.txt";
    private static final String AUTHOR_FILE_PATH = "D:\\Na4oy\\BookShopSystem\\src\\main\\resources\\files\\authors.txt";
    private static final String BOOKS_FILE_PATH = "D:\\Na4oy\\BookShopSystem\\src\\main\\resources\\files\\books.txt";
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
//
//        printTitleOfBooks(this.bookService.getAllBooksAfter2000Year());
//
//        printBooksFromGeorgePowell(this.bookService.getBooksFromGeorgePowell());
//
//        printAllAuthorsWithBooksBefore1990(this.bookService.getAllAuthorsWithBooksBefore1990());
//
  //      printAllAuthorsWithBooksBefore1990(this.bookService.getAllAuthorsNamesByNumberOfBooks());
//
        /* exr 1 */

        List<Book> books = this.bookService.getAllBooksByAgeRestriction("teEN");

        for (Book book:books) {
            System.out.println(book.getTitle());
        }

        /* exr 2 */

        List<Book> books1ist = this.bookService.getAllByEditionTypeGoldAndCopiesLessThan(5000);

        for (Book book: books1ist) {
            System.out.println(book.getTitle());
        }

        /* exr 3 */

        List<Book> booksPrice = this.bookService.getAllByPriceGreaterThanAndPriceLessThan(5,40);
        for (Book book: booksPrice) {
            System.out.println(book.getTitle() + " - $" + book.getPrice());
        }

        /* exr 4 */

        List<Book> booksYearNotIn = this.bookService.getAllBooksWithReleaseDateNotIn("1998");
        for (Book book: booksYearNotIn) {
            System.out.println(book.getTitle());
        }

        /* exr 5 */

         List<Book> booksBeforeDate = this.bookService.getAllByDateBefore("12-04-1992");
         for (Book book : booksBeforeDate) {
             System.out.println(book.getTitle()  );
         }

        /* exr 6 */

         List<Author> authors = this.authorService.getAllByFirstNameEndsWith("e");
          for (Author author : authors) {
              System.out.println(author.getFirstName() + " " + author.getLastName());
         }

         /* exr 7 */

           List<Book> booksContainsString = this.bookService.getAllByTitleContains("WOR");
           for (Book book : booksContainsString) {
             System.out.println(book.getTitle());
           }
         /* exr 8 */

            List<Book> booksByAuthorFirstName = this.bookService.getAllByAuthorFirstName("gr");
            for (Book book : booksByAuthorFirstName) {
              System.out.println(book.getTitle() + "  (" + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()+ ")");
            }
          /* exr 9 */
            Integer booksCount = this.bookService.getTitleLenghtIsLongerThan(40);
            System.out.println(booksCount);

         /* exr 10 */
           List<String> information = this.bookService.getCountOfBookCopiesForEachAuthor();
            for (String info: information){
                System.out.println(info);
            }

         /* exr 11 */
         ReduceBookDTO bookInfo = this.bookService.getInformationForBookByGivenTitle("Thrones");
         System.out.println(bookInfo.getTitle() + " " + bookInfo.getEditionType() + " " + bookInfo.getAgeRestriction()
         + " " + bookInfo.getPrice());

         /* exr 12 */

         //    this.bookService.increaseBookCopiesAfterDate("12 Oct 2005",100);

         /* exr 13 */
            this.bookService.deleteBooks(300);

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
