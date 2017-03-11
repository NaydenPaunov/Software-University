package polymorphism.wildFarm.factory;

import polymorphism.wildFarm.Animal.*;

import java.util.DoubleSummaryStatistics;

/**
 * Created by na4oy on 10.3.2017 г..
 */
public class AnimalFactory {

    public Animal getAnimal(String[] tokens){
        String type = tokens[0];
        String animalName = tokens[1];
        double animalWight = Double.parseDouble(tokens[2]);
        String livingRegion = tokens[3];

        switch (type.toLowerCase()){
            case "cat":
                String catBreed = tokens[4];
                return new Cat(animalName,type,animalWight,livingRegion,catBreed);
            case "mouse":
                return new Mouse(animalName,type,animalWight,livingRegion);
            case "zebra":
                return new Zebra(animalName,type,animalWight,livingRegion);
            case "tiger":
                return new Tiger(animalName,type,animalWight,livingRegion);
            default: return null;
        }
    }
}
