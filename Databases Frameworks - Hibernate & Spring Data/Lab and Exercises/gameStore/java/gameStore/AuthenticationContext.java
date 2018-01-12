package gameStore;

import gameStore.models.UserDto;

public class AuthenticationContext {
    private UserDto loggedInUser;


    public UserDto getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserDto loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
