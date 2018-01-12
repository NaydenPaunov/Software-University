package books.services.impl;

import books.entities.Book;
import books.entities.ReduceBookDTO;
import books.enums.AgeRestriction;
import books.enums.EditionType;
import books.repositories.BookRepository;
import books.services.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Override
    public List<Book> getAllBooksByAgeRestriction(String input) {
        String input2 = input.trim().toUpperCase();
        List<Book> founded =
                this.bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(input2).getValue());
        return founded;
    }

    @Override
    public List<Book> getAllByEditionTypeGoldAndCopiesLessThan(int copies) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD.getValue() ,copies);
    }

    @Override
    public List<Book> getAllByPriceGreaterThanAndPriceLessThan(double greaterThan, double lessThan) {
        return this.bookRepository.findAllByPriceGreaterThanAndPriceLessThan(greaterThan,lessThan);
    }

    @Override
    public List<Book> getAllBooksWithReleaseDateNotIn(String year) {
     //   Date date = new GregorianCalendar(year,0,0).getTime();
        return this.bookRepository.findByReleaseDateNot(year);
    }

    @Override
    public List<Book> getAllByDateBefore(String inputDate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.parse(inputDate);
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date);

        return books;
    }

    @Override
    public List<Book> getAllByTitleContains(String contains) {
        return this.bookRepository.findAllByTitleContains(contains);
    }

    @Override
    public List<Book> getAllByAuthorFirstName(String input) {
        String contains = "%" + input + "%";
        return this.bookRepository.findAllByAuthorFirstName(contains);
    }

    @Override
    public  Integer getTitleLenghtIsLongerThan(int number) {
        return this.bookRepository.findAllByTitleLenghtLongerThan(number);
    }

    @Override
    public List<String> getCountOfBookCopiesForEachAuthor() {
        return this.bookRepository.findCountOfBookCopiesForEachAuthor();
    }

    @Override
    public ReduceBookDTO getInformationForBookByGivenTitle(String title) {
        return this.bookRepository.findInformationForBookByGivenTitle(title);
    }

    @Override
    public void increaseBookCopiesAfterDate(String inputDate,int num) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date date = simpleDateFormat.parse(inputDate);
        List<Book> found = this.bookRepository.findAllByReleaseDateAfter(date);
        int countCopies = 0;
        for (Book book : found) {
            this.bookRepository.increaseCopies(book.getBookId(),num);
            countCopies+=num;
        }
        System.out.printf("%d books are released after %s so total of %d book copies were added"
        ,found.size(),inputDate,countCopies);
    }

    @Override
    public void deleteBooks(int num) {
        List<Book> found = this.bookRepository.findAllByCopiesLessThan(num);
        try {
            this.bookRepository.deleteWithCopiesLowerThan(num);
            System.out.printf("%s books were deleted ", found.size());
        } catch (Exception e){
            System.out.println("can not delete");
        }

    }


}
