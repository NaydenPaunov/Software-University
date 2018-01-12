package gameStore.repositories;

import gameStore.models.Game;
import gameStore.models.User;
import gameStore.models.UserDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmail(String email);
//
//    @Transactional
//    @Modifying
//    @Query("update User u set u.games = :games  where u.email = :email")
//    void setUserItemsByEmail(@Param(value = "games") Set<Game> games, @Param(value = "email") String email);
}
