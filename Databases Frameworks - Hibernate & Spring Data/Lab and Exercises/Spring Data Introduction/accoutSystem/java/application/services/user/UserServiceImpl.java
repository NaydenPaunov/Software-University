package application.services.user;

import application.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import application.repositories.UserRepository;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Long id = user.getId();

        if(id != null){
            if(userRepository.exists(id)){
                throw new RuntimeException("Dublicate user IDs");
            }
        }

        String username = user.getUsername();
        if(username != null){
           User byUsername = userRepository.findByUsername(username);

           if(byUsername != null){
               throw new RuntimeException("Dublicate usernames");
           }
        }
        userRepository.save(user);
    }
}
