package gameStore;

import gameStore.models.Game;

import java.util.Collection;
import java.util.HashMap;

public class Cart {
    private HashMap<String,Game> items;

    public Cart() {
    }

    public void addItem(Game game){
        if(items == null){
            this.items = new HashMap<>();
        }
        if(items.containsKey(game.getTitle())){
            throw new IllegalArgumentException("Game is already in cart");
        }
        this.items.put(game.getTitle(),game);
    }

    public void removeItems(String title){
        if(items == null){
            throw new IllegalArgumentException("Can not remove from empty card");
        }
        if(!items.containsKey(title)){
            throw new IllegalArgumentException("Game not present in cart");
        }
        this.items.remove(title);
    }

    public Collection<Game> getItems() {
        return items.values();
    }
}
