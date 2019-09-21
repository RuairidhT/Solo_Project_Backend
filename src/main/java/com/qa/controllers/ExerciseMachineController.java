package com.qa.controllers;

import com.qa.models.ExerciseMachine;
import com.qa.repository.ExerciseMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class ExerciseMachineController {

    @Autowired
    private ExerciseMachineRepository repository;

    @RequestMapping(value = "exerciseMachine", method = RequestMethod.GET)
    public List<ExerciseMachine> listAllExerciseMachines(){
        return repository.findAll();
    }

    @RequestMapping(value = "exerciseMachine/{id}", method = RequestMethod.GET)
    public ExerciseMachine getExerciseMachine(@PathVariable Long id){
        return repository.findOne(id);
    }


//
//    @RequestMapping(value = "exerciseMachine/{exercise_id}", method = RequestMethod.GET)
//    public List<ExerciseMachine> getMachines(@PathVariable Long exercise_id){
//        List<ExerciseMachine>
//        return repository.findA(exercise_id);
//    }




    @RequestMapping(value = "exerciseMachine", method = RequestMethod.POST)
    public ExerciseMachine addExerciseMachine(@RequestBody ExerciseMachine exerciseMachine){
        return repository.saveAndFlush(exerciseMachine);
    }

    @RequestMapping(value = "exerciseMachine/{id}", method = RequestMethod.DELETE)
    public ExerciseMachine deleteExerciseMachine(@PathVariable Long id){
        ExerciseMachine existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "exerciseMachine/{id}", method = RequestMethod.PUT)
    public ExerciseMachine updateExerciseMachine(@RequestBody ExerciseMachine exerciseMachine, @PathVariable Long id){
        ExerciseMachine exercise = repository.findOne(id);
        if (exercise != null) {
            exercise.setExerciseMachine(exerciseMachine);
        }
        return exercise;
    }
}
