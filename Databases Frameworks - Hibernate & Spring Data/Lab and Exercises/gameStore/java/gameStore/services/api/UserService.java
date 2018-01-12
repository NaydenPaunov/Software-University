package gameStore.services.api;

import gameStore.models.Game;
import gameStore.models.User;
import gameStore.models.UserDto;

import java.util.Set;

public interface UserService {
    void registerUser(User user,String confirmPassword);

    boolean checkIfUserExists(String email);

    UserDto getUserDtoByEmail(String email);

    User getUserByEmail(String email);

//    void setUserItemsByEmail(String email, Set<Game> games);
}
