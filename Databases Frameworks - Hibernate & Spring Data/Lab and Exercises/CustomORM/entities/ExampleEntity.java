package entities;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

@Entity(name = "example_entity")
public class ExampleEntity {

    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "full_name")
    private  String full_name;

    @Column(name = "age")
    private int age;

    public ExampleEntity(){}

    public ExampleEntity(String full_name,int age){
        this.full_name = full_name;
        this.age = age;
    }
}
