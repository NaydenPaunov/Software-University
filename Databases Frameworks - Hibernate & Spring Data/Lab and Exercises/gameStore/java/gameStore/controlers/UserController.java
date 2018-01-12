package gameStore.controlers;

import gameStore.AuthenticationContext;
import gameStore.models.User;
import gameStore.models.UserDto;
import gameStore.services.api.UserService;

public class UserController {
    private UserService userService;
    private AuthenticationContext authenticationContext;

    public UserController(UserService userService, AuthenticationContext authenticationContext) {
        this.userService = userService;
        this.authenticationContext = authenticationContext;
    }

    public String register(String email,String password , String confirmPassword , String fullName){
        User user = new User();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);
        try {
            this.userService.registerUser(user,confirmPassword);
        }catch (Exception e){
            return e.getMessage();
        }
        return String.format("%s register succesfully !",fullName);
    }

    public String login(String email,String password){
        if(!this.userService.checkIfUserExists(email)){
            return "User does not exist!";
        }
        this.authenticationContext.setLoggedInUser(this.userService.getUserDtoByEmail(email));
        return "User logged in successfully!";
    }
}
