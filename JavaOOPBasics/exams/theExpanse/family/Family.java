package theExpanse.family;

import theExpanse.colonist.Colonist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Family {
    private String id;
    private List<Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Colonist> getColonists() {
        return Collections.unmodifiableList(this.colonists);
    }

    public void addColonists(Colonist colonist){
        this.colonists.add(colonist);
    }

    public void removeColonists(Colonist colonist){
        this.colonists.remove(colonist);
    }
}
