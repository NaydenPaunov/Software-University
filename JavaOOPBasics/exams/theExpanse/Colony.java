package theExpanse;

import theExpanse.colonist.Colonist;
import theExpanse.family.Family;

import java.util.*;

public class Colony {
    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private Map<String,Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new TreeMap<>();
    }

    public int getMaxFamilyCount() {
        return maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return maxFamilyCapacity;
    }

    public Map<String, Family> getFamilies() {
        return Collections.unmodifiableMap(this.families);
    }


    public void addColonist(Colonist colonist){
        String familyId = colonist.getFamilyId();

        if(this.families.containsKey(familyId)){
            if(this.families.get(familyId).getColonists().size() < maxFamilyCapacity){
                this.families.get(familyId).addColonists(colonist);
            }else {
                System.out.println("family is full");
            }
        }else{
            Family family = new Family(familyId);
            this.families.putIfAbsent(familyId,family);
            if(this.families.get(familyId).getColonists().size() < maxFamilyCapacity){
                family.addColonists(colonist);
            }else {
                System.out.println("colony is full");
            }
        }
    }

    public void removeColonist(String familyId, String memberId){
        if(this.families.containsKey(familyId)){
            Family family = this.families.get(familyId);
            List<Colonist> colonists = family.getColonists();
            Colonist colonistSearch = null;
            for (Colonist colonist : colonists) {
                if(colonist.getId().equals(memberId)){
                    colonistSearch = colonist;
                }
            }
            family.removeColonists(colonistSearch);
        }
        if(this.families.containsKey(familyId) && this.families.get(familyId).getColonists().size() == 0){
            this.families.remove(familyId);
        }
    }

    public void removeFamily(String id){
        if(this.families.containsKey(id)){
            this.families.remove(id);
        }
    }

    public List<Colonist> getColonistsByFamilyId(String familyId){
        if(this.families.containsKey(familyId)){
            return this.families.get(familyId).getColonists();
        }
        return  null;
    }

    public void grow(int years){
        for (Family family : families.values()) {
            List<Colonist> colonists = family.getColonists();
            for (Colonist colonist : colonists) {
                colonist.grow(years);
            }
        }
    }

    public int getPotential(){
        int potential = 0;
        for (Family family : families.values()) {
            List<Colonist> colonists = family.getColonists();
            for (Colonist colonist : colonists) {
                potential += colonist.getPotential();
            }
        }
        return potential;
    }

    public String getCapacity(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d",this.families.size(),maxFamilyCount));
        sb.append(System.lineSeparator());

        for (Family family : families.values()) {
            sb.append(String.format("-%s: %d/%d",family.getId(),family.getColonists().size(),maxFamilyCapacity));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
