package Encapsulation.FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by na4oy on 1.3.2017 г..
 */
public class Team {
    private String name ;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
        this.name = name;
        firstTeam = new ArrayList<>();
        reserveTeam = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    public void addPlayer(Person person){
        if(person.getAge() < 40){
            this.firstTeam.add(person);
        }else{
            this.reserveTeam.add(person);
        }
    }
}
