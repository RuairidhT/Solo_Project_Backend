package com.qa.controllers;


import com.qa.models.Exercise;
import com.qa.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class ExerciseController {

    @Autowired
    private ExerciseRepository repository;

    @RequestMapping(value = "exercises", method = RequestMethod.GET)
    public List<Exercise> listAllExercises(){
        return repository.findAll();
    }

    @RequestMapping(value = "exercises", method = RequestMethod.POST)
    public Exercise addNote(@RequestBody Exercise exercise){
        return repository.saveAndFlush(exercise);
    }

    //delete by ID
    @RequestMapping(value = "exercises/{id}", method = RequestMethod.DELETE)
    public Exercise deleteNote(@PathVariable Long id){
        Exercise existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @RequestMapping(value = "exercises/name/{name}", method = RequestMethod.GET)
    public Exercise getNote(@PathVariable("name") String name){
        return repository.findOne(name);
    }

}
