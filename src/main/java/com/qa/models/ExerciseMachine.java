package com.qa.models;

import javax.persistence.*;

@Entity
@Table(name = "exercise_machine")
public class ExerciseMachine {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long ID;
    private Long exercise_id;
    private Long machine_id;

    public ExerciseMachine(){
        super();
    }

    public ExerciseMachine(Long exercise_id, Long machine_id) {
        this.exercise_id = exercise_id;
        this.machine_id = machine_id;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(Long exercise_id) {
        this.exercise_id = exercise_id;
    }

    public Long getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(Long machine_id) {
        this.machine_id = machine_id;
    }
}
