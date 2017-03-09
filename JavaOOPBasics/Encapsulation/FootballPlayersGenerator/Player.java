package Encapsulation.FootballPlayersGenerator;

/**
 * Created by na4oy on 7.3.2017 г..
 */
public class Player {
    private final static String EXCEPTION_MESSAGE =String.format("%s should be between 0 and 100.");
    private final static Double SKILL_COUNT = 5.0;

    private String name;
    private Double endurance;
    private Double sprint;
    private Double dribble;
    private Double passing;
    private Double shooting;

    public Player(String name, Double endurance, Double sprint, Double dribble, Double passing, Double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    public Double getSkill(){
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting)/SKILL_COUNT;
    }


    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new MyException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(Double endurance) {
        validationData(endurance,"Endurance");
        this.endurance = endurance;
    }

    private void setSprint(Double sprint) {
        validationData(sprint,"Sprint");
        this.sprint = sprint;
    }

    private void setDribble(Double dribble) {
        validationData(dribble,"Dribble");
        this.dribble = dribble;
    }

    private void setPassing(Double passing) {
        validationData(passing,"Passing");
        this.passing = passing;
    }

    private void setShooting(Double shooting) {
        validationData(shooting,"Shooting");
        this.shooting = shooting;
    }

    private void validationData(Double data, String type) {
        if(data < 0 || data > 100 ){
            throw new MyException(String.format(EXCEPTION_MESSAGE,type));
        }
    }

}
