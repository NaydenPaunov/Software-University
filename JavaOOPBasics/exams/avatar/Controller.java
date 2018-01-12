package avatar;

import avatar.benders.Bender;
import avatar.monuments.Monument;
import java.util.ArrayList;

class Controller {

    private static Nation airNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation fireNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation earthNation = new Nation(new ArrayList<>(), new ArrayList<>());
    private static Nation waterNation = new Nation(new ArrayList<>(), new ArrayList<>());

    static Nation getAirNation() {
        return airNation;
    }

    static Nation getFireNation() {
        return fireNation;
    }

    static Nation getEarthNation() {
        return earthNation;
    }

    static Nation getWaterNation() {
        return waterNation;
    }

    static String getStatus(String type) {
        Nation currentNation = getNation(type);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Nation",type)).append(System.lineSeparator());


        if(currentNation.getBenders().size() > 0) {
            sb.append("Benders:").append(System.lineSeparator());
            for (Bender bender : currentNation.getBenders()) {
                sb.append(bender).append(System.lineSeparator());
            }
        } else{
            sb.append("Benders: None").append(System.lineSeparator());
        }

        if(currentNation.getMonuments().size() > 0){
            sb.append("Monuments:").append(System.lineSeparator());
            for (Monument monument : currentNation.getMonuments()) {
                sb.append(monument).append(System.lineSeparator());
            }
        } else {
            sb.append("Monuments: None").append(System.lineSeparator());
        }

        return sb.toString();
    }

    static void beginWar() {
        double airPower = airNation.calculateNationPower();
        double firePower = fireNation.calculateNationPower();
        double earthPower = earthNation.calculateNationPower();
        double waterPower = waterNation.calculateNationPower();

        if(airPower > firePower && airPower > waterPower && airPower > earthPower) {
            clearNationBendersAndMonuments(fireNation, waterNation, earthNation);
        } else if(firePower > airPower && firePower > waterPower && firePower > earthPower) {
            clearNationBendersAndMonuments(airNation, waterNation, earthNation);
        } else if(waterPower > firePower && waterPower > airPower && waterPower > earthPower) {
            clearNationBendersAndMonuments(fireNation, airNation, earthNation);
        } else {
            clearNationBendersAndMonuments(fireNation, waterNation, airNation);
        }
    }

    private static Nation getNation(String type) {
        switch (type){
            case "Air":
                return airNation;
            case "Fire":
                return fireNation;
            case "Earth":
                return earthNation;
            case "Water":
                return waterNation;
            default:
                return null;
        }
    }

    private static void clearNationBendersAndMonuments(Nation n1, Nation n2, Nation n3) {
        n1.clearBenders();
        n1.clearMonuments();
        n2.clearBenders();
        n2.clearMonuments();
        n3.clearBenders();
        n3.clearMonuments();
    }
}
