package pawInc.animals;

/**
 * Created by na4oy on 11.3.2017 г..
 */
public abstract class Animal {
    private String name;
    private Integer age;
    private boolean cleansingStatus;
    private String adoptionCenter;

    protected Animal(String name, Integer age){
        this.name = name;
        this.age = age;
        this.cleansingStatus = false;
    }

    protected Animal(String name, Integer age, String adoptionCenter) {
        this(name,age);
        this.adoptionCenter = adoptionCenter;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCleansingStatus() {
        return this.cleansingStatus;
    }

    public void cleanse(){
        this.cleansingStatus = true;
    }

    public String getCenterName() {
        return this.adoptionCenter;
    }
}
