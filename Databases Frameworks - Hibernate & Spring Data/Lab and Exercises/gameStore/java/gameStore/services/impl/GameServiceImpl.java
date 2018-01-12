package gameStore.services.impl;

import gameStore.models.Game;
import gameStore.models.User;
import gameStore.repositories.GameRepository;
import gameStore.services.api.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
@Transactional
public class GameServiceImpl implements GameService {
    private GameRepository gameRepository;
    private Validator validator;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.getValidator();
    }

    @Override
    public void addGame(Game game) {
       if(this.checkIfGameExists(game.getTitle())){
           throw new IllegalArgumentException("Game already exists!");
       }

        Set<ConstraintViolation<Game>> constraintViolations = validator.validate(game);
        if(constraintViolations.size() == 0){
            this.gameRepository.save(game);
        }else{
            for (ConstraintViolation<Game> constraintViolation : constraintViolations) {
                System.out.println(constraintViolation.getMessage());
            }
        }
    }

    @Override
    public boolean checkIfGameExists(String title) {
        Game game = this.gameRepository.findByTitle(title);
        return game != null;
    }

    @Override
    public Game findGameByTitle(String title) {
        return this.gameRepository.findByTitle(title);
    }

    @Override
    public Set<Game> all() {
        return this.gameRepository.findAll();
    }

    @Override
    public String deleteGame(Long id) {
        if(this.gameRepository.findOne(id) == null){
          return "Game do not exists";
        }
        this.gameRepository.deleteById(id);
        return "Game successfully deleted";
    }

    private void getValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }
}
