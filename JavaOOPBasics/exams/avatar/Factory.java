package avatar;

import avatar.benders.AirBender;
import avatar.benders.EarthBender;
import avatar.benders.FireBender;
import avatar.benders.WaterBender;
import avatar.monuments.AirMonument;
import avatar.monuments.EarthMonument;
import avatar.monuments.FireMonument;
import avatar.monuments.WaterMonument;

final class Factory {

    static void createBender(String type, String name, int power, double secPar){

        switch (type){
            case "Air":
                Controller.getAirNation().addBender(new AirBender(name,power,secPar));
                break;
            case "Fire":
                Controller.getFireNation().addBender(new FireBender(name,power,secPar));
                break;
            case "Earth":
                Controller.getEarthNation().addBender(new EarthBender(name,power,secPar));
                break;
            case "Water":
                Controller.getWaterNation().addBender(new WaterBender(name,power,secPar));
                break;
            default:
                break;
        }
    }

    static void createMonument(String type,String name, int affinity){
        switch (type){
            case "Air":
                Controller.getAirNation().addMonument(new AirMonument(name,affinity));
                break;
            case "Fire":
                Controller.getFireNation().addMonument(new FireMonument(name,affinity));
                break;
            case "Earth":
                Controller.getEarthNation().addMonument(new EarthMonument(name,affinity));
                break;
            case "Water":
                Controller.getWaterNation().addMonument(new WaterMonument(name,affinity));
                break;
            default:
                break;
        }
    }

}
