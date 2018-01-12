package avatar;

import avatar.benders.Bender;
import avatar.monuments.Monument;
import java.util.Collections;
import java.util.List;

class Nation {

    private List<Bender> benders;
    private List<Monument> monuments;

    Nation(List<Bender> benders, List<Monument> monuments) {
        this.benders = benders;
        this.monuments = monuments;
    }

    void addBender(Bender bender){
        this.benders.add(bender);
    }

    void addMonument(Monument monument){
        this.monuments.add(monument);
    }

    List<Monument> getMonuments(){
        return Collections.unmodifiableList(this.monuments);
    }

    List<Bender> getBenders(){
        return Collections.unmodifiableList(this.benders);
    }

    double calculateNationPower(){
        double total = 0.0;
        for (Bender bender : this.benders) {
            total += bender.getTotalPower();
        }

        Long sum = 0L;
        for (Monument monument : this.monuments) {
            sum += monument.getPower();
        }

        total = (total / 100) * sum;
        return total;
    }

    void clearMonuments(){
        this.monuments.clear();
    }

    void clearBenders(){
        this.benders.clear();
    }
}
