package gameStore.controlers;

import gameStore.AuthenticationContext;
import gameStore.models.Game;
import gameStore.services.api.GameService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class GameController {
    private GameService gameService;
    private AuthenticationContext authenticationContext;

    public GameController(GameService gameService, AuthenticationContext authenticationContext) {
        this.gameService = gameService;
        this.authenticationContext = authenticationContext;
    }

    public String add(String title, BigDecimal price,BigDecimal size,
                      String trailer, String thumbnailUrl, String description , Date releaseDate){
        if(this.authenticationContext.getLoggedInUser() == null){
            return "You have to login first";
        }
        if(!this.authenticationContext.getLoggedInUser().isAdmin()){
            return "You must be admin to add games";
        }
        Game game = new Game();
        game.setTitle(title);
        game.setPrice(price);
        game.setSize(size);
        game.setTrailer(trailer);
        game.setThumbnailUrl(thumbnailUrl);
        game.setDescription(description);
        try{
            this.gameService.addGame(game);
        }catch (Exception e){
          return e.getMessage();
        }
        return "Game added successfully!";

    }

    public String delete(Long id){
        if(this.authenticationContext.getLoggedInUser() == null){
            return "You have to login first";
        }
        if(!this.authenticationContext.getLoggedInUser().isAdmin()){
            return "You must be admin to delete games";
        }
        return this.gameService.deleteGame(id);
    }

    public String all(){
        Set<Game> allGames = this.gameService.all();
        StringBuilder sb = new StringBuilder();
        for (Game game : allGames) {
            sb.append(game.getTitle()).append(" ");
            sb.append(game.getPrice()).append(" ");
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    public String detail(String title){
        Game game = this.gameService.findGameByTitle(title);
        return String.format(" Title: %s %n Price: %.2f %n Description: %s%n",game.getTitle(),game.getPrice(),
                game.getDescription());
    }
}
