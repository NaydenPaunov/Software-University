package gameStore.repositories;

import gameStore.models.Game;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface GameRepository extends CrudRepository<Game,Long> {

    Game findByTitle(String title);

    Set<Game> findAll();

    @Modifying
    @Transactional
    @Query("delete from User u where u.id = :id")
    void deleteById(@Param(value = "id") Long id);
}
