package books.repositories;

import books.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findAllByFirstNameLike(String pattern);

    List<Author> findAllByFirstNameContains(String contains);

}
