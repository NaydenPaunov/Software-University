package DefiningClassesExr.PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by na4oy on 28.2.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Trainer> trainers = new ArrayList<>();

        String[] line = reader.readLine().split("\\s+");
        while (!line[0].equals("Tournament")) {
            Trainer trainer = null;
            String trainerName = line[0];
            String pokemonName = line[1];
            String pokemonElement = line[2];
            Integer pokemonHealth = Integer.parseInt(line[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainers.size() == 0) {
                trainer = new Trainer(trainerName, pokemon);
                trainers.add(trainer);
            } else {
                for (Trainer trainer1 : trainers) {
                    if (trainer1.getTrainerName().equals(trainerName)) {
                        trainer1.getPokemons().add(pokemon);
                        break;
                    } else {
                        trainer = new Trainer(trainerName, pokemon);
                        trainers.add(trainer);
                        break;
                    }
                }
            }
            line = reader.readLine().split("\\s+");
        }

        String inputLine = reader.readLine();
        while (!inputLine.equals("End")) {
            switch (inputLine) {
                case "Fire":
                    checkPokemons("Fire", trainers);
                    break;
                case "Water":
                    checkPokemons("Water", trainers);
                    break;
                case "Electricity":
                    checkPokemons("Electricity", trainers);
                    break;
            }
            inputLine = reader.readLine();

        }
        checkPokemonsHealth(trainers);

        //print
        for (int i = 0; i < trainers.size(); i++) {
            for (Trainer trainer : trainers) {
                Integer numOfBadget = 0;
                if (trainer.getTrainerBadgets() > numOfBadget) {
                    System.out.print(trainer.getTrainerName());
                    System.out.print(" " + trainer.getTrainerBadgets());
                    System.out.println(" " + trainer.getPokemons().size());
                    trainers.remove(trainer);
                }
            }
        }
        if (trainers.size() != 0) {
            for (Trainer trainer : trainers) {
                System.out.print(trainer.getTrainerName());
                System.out.print(" " + trainer.getTrainerBadgets());
                System.out.println(" " + trainer.getPokemons().size());
            }
        }

    }

    private static void checkPokemonsHealth(List<Trainer> trainers) {
        for (Trainer trainer : trainers) {
            try {
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getPokemonHealth() <= 0) {
                        trainer.getPokemons().remove(pokemon);
                    }
                }
            } catch (ConcurrentModificationException ex) {
            }
        }
    }


    private static void checkPokemons(String element, List<Trainer> trainers) {
        for (Trainer trainer : trainers) {
            Integer counter = 0;
            for (Pokemon pokemon : trainer.getPokemons()) {
                if (element.equals(pokemon.getPokemonElement())) {
                    counter++;
                }
            }

            if (counter.equals(0)) {
                for (Pokemon pokemon : trainer.getPokemons()) {
                    pokemon.setPokemonHealth(pokemon.getPokemonHealth() - 10);
                }
            } else {
                trainer.setTrainerBadgets(trainer.getTrainerBadgets() + 1);
            }
        }
    }
}




