package DefiningClassesExr.PokemonTrainer;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Pokemon {
    private String pokemonName;
    private String pokemonElement;
    private Integer pokemonHealth;


    public Pokemon(String pokemonName, String pokemonElement, Integer pokemonHealth) {
        this.pokemonName = pokemonName;
        this.pokemonElement = pokemonElement;
        this.pokemonHealth = pokemonHealth;
    }

    public String getPokemonName() {
        return this.pokemonName;
    }

    public String getPokemonElement() {
        return this.pokemonElement;
    }

    public Integer getPokemonHealth() {
        return this.pokemonHealth;
    }

    public void setPokemonHealth(Integer pokemonHealth) {
        this.pokemonHealth = pokemonHealth;
    }
}
