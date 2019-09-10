package com.qa.controllers;

import com.qa.models.Exercise;
import com.qa.models.Workouts;
import com.qa.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class WorkoutController {


    @Autowired
    private WorkoutRepository repository;

    @RequestMapping(value = "workouts", method = RequestMethod.GET)
    public List<Workouts> listAllWorkouts() {
        return repository.findAll();
    }

    @RequestMapping(value = "workouts", method = RequestMethod.POST)
    public Workouts addNote(@RequestBody Workouts workouts) {
        return repository.saveAndFlush(workouts);
    }

    //delete by ID
    @RequestMapping(value = "workouts/{id}", method = RequestMethod.DELETE)
    public Workouts deleteNote(@PathVariable Long id) {
        Workouts existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "workouts/{id}", method = RequestMethod.PUT)
    public Workouts list(@RequestBody Workouts workouts, @PathVariable Long id) {
        Workouts workout = repository.findOne(id);
        if (workout != null) {
            workout.setWorkouts(workouts);
        }
        return workout;
    }

}


}
