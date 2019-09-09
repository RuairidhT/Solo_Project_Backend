package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "Exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    Long id;

    private String name;
    private String muscleGroup;
    private String description;
    private String tutorial;

    public Exercise(String name, String muscleGroup, String description, String tutorial) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.description = description;
        this.tutorial = tutorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
}
