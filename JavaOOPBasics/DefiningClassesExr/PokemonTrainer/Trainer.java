package DefiningClassesExr.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Trainer {
    private static final Integer TRAINER_BADGETS = 0;

    private String trainerName;
    private Integer trainerBadgets = TRAINER_BADGETS;
    private List<Pokemon> pokemons = new ArrayList<>();


    public Trainer(String trainerName, Pokemon pokemons) {
        this.trainerName = trainerName;
        this.pokemons.add(pokemons);
    }

    public String getTrainerName() {
        return this.trainerName;
    }

    public Integer getTrainerBadgets() {
        return this.trainerBadgets;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setTrainerBadgets(Integer trainerBadgets) {
        this.trainerBadgets = trainerBadgets;
    }
}
