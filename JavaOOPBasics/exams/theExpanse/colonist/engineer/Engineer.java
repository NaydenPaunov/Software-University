package theExpanse.colonist.engineer;

import theExpanse.colonist.Colonist;

abstract class Engineer extends Colonist {

    Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        int potential = super.getTalent() + 3;
        if(super.getAge() > 30){
            potential += 2;
        }
        return potential;
    }
}
