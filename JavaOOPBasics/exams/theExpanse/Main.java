package theExpanse;

import theExpanse.colonist.Colonist;
import theExpanse.colonist.Soldier;
import theExpanse.colonist.engineer.HardwareEngineer;
import theExpanse.colonist.engineer.SoftwareEngineer;
import theExpanse.colonist.medics.GeneralPractitioner;
import theExpanse.colonist.medics.Surgeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] capacity = reader.readLine().split(" ");
        int maxFamilyCount = Integer.parseInt(capacity[0]);
        int maxFamilyCapacity = Integer.parseInt(capacity[1]);

        Colony colony = new Colony(maxFamilyCount,maxFamilyCapacity);

        while (true) {
            String[] line = reader.readLine().split(" ");
            if(line[0].equals("end")) {
                break;
            }

            String commands = line[0];
            switch (commands){
                case "insert":
                    Colonist currentColonist = getColonist(line);
                    colony.addColonist(currentColonist);
                    break;
                case "remove":
                        if(line[1].equals("family")){
                            colony.removeFamily(line[2]);
                        }else if(line[1].equals("colonist")){
                            colony.removeColonist(line[2],line[3]);
                        }
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(line[1]));
                    break;
                case "potential":
                    System.out.printf("potential: %d%n",colony.getPotential());
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    List<Colonist> colonists = colony.getColonistsByFamilyId(line[1]);
                    List<Colonist> collect = colonists.stream().sorted(Comparator.comparing(Colonist::getId)).collect(Collectors.toList());
                    StringBuilder sb = new StringBuilder();
                    sb.append(line[1]).append(":").append(System.lineSeparator());
                    for (Colonist colonist : collect) {
                        sb.append(String.format("-%s: %d%n",colonist.getId(),colonist.getPotential()));
                    }
                    System.out.println(sb.toString().trim());
                    break;
                default:
                    break;
            }
        }
    }

    private static Colonist getColonist(String[] line) {
        Colonist colonist = null;
        switch (line[1]){
            case "SoftwareEngineer":
                colonist = new SoftwareEngineer(line[2],line[3],
                        Integer.parseInt(line[4]),Integer.parseInt(line[5]));
                break;
            case "HardwareEngineer":
                colonist = new HardwareEngineer(line[2],line[3],
                        Integer.parseInt(line[4]),Integer.parseInt(line[5]));
                break;
            case "Soldier":
                colonist = new Soldier(line[2],line[3],
                        Integer.parseInt(line[4]),Integer.parseInt(line[5]));
                break;
            case "GeneralPractitioner":
                colonist = new GeneralPractitioner(line[2],line[3],
                        Integer.parseInt(line[4]),Integer.parseInt(line[5]),line[6]);
                break;
            case "Surgeon":
                colonist = new Surgeon(line[2],line[3],
                        Integer.parseInt(line[4]),Integer.parseInt(line[5]),line[6]);
        }
        return colonist;
    }
}
