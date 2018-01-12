package theExpanse.colonist.medics;

import theExpanse.colonist.Colonist;

abstract class Medic extends Colonist {
    private String sign;

    Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    @Override
    public int getPotential() {
        return (super.getTalent() + 2) ;
    }

    public String getSign() {
        return sign;
    }
}
