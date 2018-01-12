package books.utilities;

import books.entities.Book;
import books.entities.Category;
import books.enums.AgeRestriction;
import books.enums.EditionType;
import books.services.api.AuthorService;
import books.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class ReadBooksFile {

    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public ReadBooksFile(CategoryService categoryService, AuthorService authorService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    public List<Book> read(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();
        Path bookPath = Paths.get(filePath);
        final SimpleDateFormat dtf = new SimpleDateFormat("d/M/yyyy");
        List<Category> allCategories = this.categoryService.findAll();
        Random random = new Random();

        for(String line : Files.readAllLines(bookPath).stream().skip(1).toArray(String[]::new)){
            String[] tokens = line.split("\\s++");
            try {
                Constructor<Book> declaredConstructor = Book.class.getDeclaredConstructor();
                Book book = declaredConstructor.newInstance();
                book.setEditionType(EditionType.values()[Integer.parseInt(tokens[0])]);
                Date date = dtf.parse(tokens[1]);
                book.setReleaseDate(date);
                book.setCopies(Integer.parseInt(tokens[2]));
                book.setPrice(Double.parseDouble(tokens[3]));
                book.setAgeRegistration(AgeRestriction.values()[Integer.parseInt(tokens[4])]);
                book.setTitle(Arrays.stream(tokens).skip(5).collect(Collectors.joining(" ")));

                Set<Category> categories = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    int index = random.nextInt(allCategories.size());
                    categories.add(allCategories.get(index));
                }

                book.setCategories(categories);
                book.setAuthor(this.authorService.findById(random.nextInt(30)));
                books.add(book);

            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | ParseException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

}
