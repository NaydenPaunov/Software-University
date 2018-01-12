package gameStore.services.api;

import gameStore.models.Game;

import java.util.Collection;

public interface OrderService {

    void buyItems(Collection<Game> products,String email);
}
