package books.services.api;

import books.entities.Category;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    void createAll(List<Category> categories);
}
