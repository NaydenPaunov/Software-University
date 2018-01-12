package gameStore.services.api;

import gameStore.models.Game;

import java.util.Set;

public interface GameService {
    void addGame(Game game);

    boolean checkIfGameExists(String title);

    Game findGameByTitle(String title);

    Set<Game> all();

    String deleteGame(Long id);
}
