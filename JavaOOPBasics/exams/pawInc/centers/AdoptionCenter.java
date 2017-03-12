package pawInc.centers;

import pawInc.animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by na4oy on 11.3.2017 г..
 */
public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter center){
        List<Animal> animals = super.getAnimals().stream()
                .filter(a -> !a.isCleansingStatus())
                .collect(Collectors.toList());

        super.removeAnimals(animals);
       center.registerAll(animals);
    }

    public List<Animal> adopt(){
        List<Animal> animals = super.getAnimals().stream()
                .filter(a -> a.isCleansingStatus())
                .collect(Collectors.toList());
        super.registerAll(animals);
        return animals;

    }
}
