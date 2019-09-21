package com.qa.controllers;

import com.qa.models.Exercise;
import com.qa.models.ExerciseMachine;
import com.qa.models.Machine;
import com.qa.repository.ExerciseMachineRepository;
import com.qa.repository.ExerciseRepository;
import com.qa.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
public class ExerciseMachineController {

    @Autowired
    private ExerciseMachineRepository repository;
    @Autowired
    private MachineRepository machineRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;

    @RequestMapping(value = "exerciseMachine", method = RequestMethod.GET)
    public List<ExerciseMachine> listAllExerciseMachines() {
        return repository.findAll();
    }

    @RequestMapping(value = "exerciseMachine/{id}", method = RequestMethod.GET)
    public ExerciseMachine getExerciseMachine(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "exercise-machine/{exercise_id}", method = RequestMethod.GET)
    public List<Machine> getMachines(@PathVariable Long exercise_id) {
        List<ExerciseMachine> exerciseMachineList = repository.findAll();
        List<Machine> machineList = machineRepository.findAll();
        List<Machine> mList = new ArrayList<>();
        for (int i = 0; i < exerciseMachineList.size(); i++) {
            if(exercise_id.equals(exerciseMachineList.get(i).getExercise_id())){
                Long machineId = exerciseMachineList.get(i).getMachine_id();
                for(int j=0; j<machineList.size(); j++) {
                    if(machineId.equals(machineList.get(j).getID())) {
                        mList.add(machineList.get(j));
                    }
                }
            }
        }
        return mList;
    }

    @RequestMapping(value = "machine-exercise/{machine_id}", method = RequestMethod.GET)
    public List<Exercise> getExercises(@PathVariable Long machine_id) {
        List<ExerciseMachine> exerciseMachineList = repository.findAll();
        List<Exercise> exerciseList = exerciseRepository.findAll();
        List<Exercise> eList = new ArrayList<>();
        for (int i = 0; i < exerciseMachineList.size(); i++) {
            if(machine_id.equals(exerciseMachineList.get(i).getMachine_id())){
                Long exerciseId = exerciseMachineList.get(i).getExercise_id();
                for(int j=0; j<exerciseList.size(); j++) {
                    if(exerciseId.equals(exerciseList.get(j).getID())) {
                        eList.add(exerciseList.get(j));
                    }
                }
            }
        }
        return eList;
    }

    @RequestMapping(value = "exerciseMachine", method = RequestMethod.POST)
    public ExerciseMachine addExerciseMachine(@RequestBody ExerciseMachine exerciseMachine) {
        return repository.saveAndFlush(exerciseMachine);
    }

    @RequestMapping(value = "exerciseMachine/{id}", method = RequestMethod.DELETE)
    public ExerciseMachine deleteExerciseMachine(@PathVariable Long id) {
        ExerciseMachine existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "exerciseMachine/{id}", method = RequestMethod.PUT)
    public ExerciseMachine updateExerciseMachine(@RequestBody ExerciseMachine exerciseMachine, @PathVariable Long id) {
        ExerciseMachine exercise = repository.findOne(id);
        if (exercise != null) {
            exercise.setExerciseMachine(exerciseMachine);
        }
        return exercise;
    }
}
