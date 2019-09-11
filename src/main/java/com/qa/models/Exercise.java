package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "Exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long ID;
    private String Name;
    private String MuscleGroup;
    private String Description;
    private String Tutorial;

    public Exercise() {
        super();
    }

    public Exercise(String name, String muscleGroup, String description, String tutorial) {
        this.Name = name;
        this.MuscleGroup = muscleGroup;
        this.Description = description;
        this.Tutorial = tutorial;
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

    public String getMuscleGroup() {
        return MuscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.MuscleGroup = muscleGroup;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getTutorial() {
        return Tutorial;
    }

    public void setTutorial(String tutorial) {
        this.Tutorial = tutorial;
    }

    public void setExercise(Exercise exercise){
        this.Name = exercise.Name;
        this.MuscleGroup = exercise.MuscleGroup;
        this.Description = exercise.Description;
        this.Tutorial = exercise.Tutorial;
    }

}
