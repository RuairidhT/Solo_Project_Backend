package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long ID;
    private String Name;
    private String Description;

    public Machine() {
        super();
    }

    public Machine(String name, String description) {
        this.Name = name;
        this.Description = description;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }


    public void setMachine(Machine machine){
        this.Name = machine.Name;
        this.Description = machine.Description;
    }

}
