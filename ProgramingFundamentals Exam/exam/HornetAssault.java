package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by na4oy on 26.2.2017 г..
 */
public class HornetAssault {
    private static List<Long> bees = new ArrayList<>();
    private static List<Long> horner = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] beehives  = reader.readLine().trim().split("\\s+");
        String[] hornetNumbers = reader.readLine().trim().split("\\s+");

        addBeehivesInList(beehives);
        addHornetInList(hornetNumbers);

        Integer beesSize = bees.size();
        try {
            for (int i = 0; i < beesSize; i++) {
                Long hornerPower = calculateHornerPower();
                Long beesInfirst = bees.get(0);
                if (hornerPower > beesInfirst) {
                    bees.remove(0);
                } else if (beesInfirst >= hornerPower) {
                    Long beesLast = beesInfirst - hornerPower;
                    if (beesLast == 0) {
                        bees.remove(0);
                        horner.remove(0);
                    } else {
                        bees.remove(0);
                        bees.add(beesLast);
                        horner.remove(0);
                    }
                }
            }
        }catch (IndexOutOfBoundsException ex){

        }catch (NumberFormatException ex){
            ex.getMessage();
        }


        if(bees.size() != 0 && bees.get(0) != 0 ){
            for (Long bee : bees) {
                System.out.print(bee + " ");
            }
        }else {
            for (Long h : horner) {
                System.out.print(h + " ");
            }
        }

    }

    private static Long calculateHornerPower() {
        Long power = 0l;
        for (Long horners : horner) {
            power += horners;
        }
        return power;
    }

    private static void addHornetInList(String[] hornetNumbers) {
        for (int i = 0; i < hornetNumbers.length; i++) {
            if(!hornetNumbers[i].equals(0)){
                horner.add(Long.valueOf(hornetNumbers[i]));
            }
        }
    }

    private static void addBeehivesInList(String[] beehives) {
        for (int i = 0; i < beehives.length ;i++) {
            if(!beehives[i].equals(0)){
                bees.add(Long.valueOf(beehives[i]));
            }

        }
    }
}
