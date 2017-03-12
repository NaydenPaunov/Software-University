package pawInc.centers;

import pawInc.animals.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 11.3.2017 г..
 */
public class CleansingCenter extends Center{

    public CleansingCenter(String name) {
        super(name);
    }

    public List<Animal> cleanse (){
        List<Animal> cleansed = new ArrayList<>();
        super.getAnimals().stream().forEach(a -> {
            a.cleanse();
            cleansed.add(a);
        });
        super.removeAnimals(cleansed);
        return cleansed;
    }

}