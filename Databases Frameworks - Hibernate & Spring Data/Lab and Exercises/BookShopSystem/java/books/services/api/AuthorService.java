package books.services.api;

import books.entities.Author;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface AuthorService {
    Author findById(long id);

    void createAll(List<Author> authors);

    List<Author> getAllByFirstNameEndsWith(String input);

    List<Author> getAllByFirstNameContains(String input);
}
