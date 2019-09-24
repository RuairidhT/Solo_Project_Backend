package com.qa.controllers;

import com.qa.models.Exercise;
import com.qa.models.ExerciseMachine;
import com.qa.models.Machine;
import com.qa.repository.ExerciseMachineRepository;
import com.qa.repository.ExerciseRepository;
import com.qa.repository.MachineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExerciseMachineControllerTest {

    @InjectMocks
    private ExerciseMachineController exerciseMachineController;

    @Mock
    private ExerciseMachineRepository repository;

    @Mock
    private MachineRepository machineRepository;

    @Mock
    private ExerciseRepository exerciseRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testGetAllExMachine() {
        List<ExerciseMachine> exerciseMachineList = new ArrayList<>();
        ExerciseMachine exerciseMachine = new ExerciseMachine();
        exerciseMachine.setExercise_id(1L);
        exerciseMachine.setMachine_id(1L);
        exerciseMachine.setID(1L);
        exerciseMachineList.add(exerciseMachine);

        when(repository.findAll()).thenReturn(exerciseMachineList);
        assertEquals(exerciseMachineController.listAllExerciseMachines().get(0).getID().toString(), "1");
    }

    @Test
    public void testGetOneMachExercise() {

        List<ExerciseMachine> exerciseMachineList = new ArrayList<>();
        ExerciseMachine exerciseMachine = new ExerciseMachine(1L, 1L);
        exerciseMachineList.add(exerciseMachine);

        when(repository.findOne(1L)).thenReturn(exerciseMachine);
        assertEquals(exerciseMachineController.getExerciseMachine(1L).getMachine_id().toString(), "1");
    }

    @Test
    public void testDeleteMachExercise(){

        List<ExerciseMachine> exerciseMachineList = new ArrayList<>();
        ExerciseMachine exerciseMachine = new ExerciseMachine();
        exerciseMachine.setExercise_id(1L);
        exerciseMachine.setMachine_id(1L);
        exerciseMachineList.add(exerciseMachine);

        when(repository.findAll()).thenReturn(exerciseMachineList);
        assertEquals(exerciseMachineController.deleteExerciseMachine(1L, 1L).getMachine_id().toString(), "1");
    }

    @Test
    public void TestAddMachExercise(){
        ExerciseMachine exerciseMachine = new ExerciseMachine();
        exerciseMachine.setExercise_id(1L);
        exerciseMachine.setMachine_id(1L);

        when(repository.saveAndFlush(exerciseMachine)).thenReturn(exerciseMachine);
        assertEquals(exerciseMachineController.addExerciseMachine(exerciseMachine).getMachine_id().toString(), "1");
    }

    @Test
    public void testGetMachines(){

        List<Machine> machineList = new ArrayList<>();
        Machine machine = new Machine();
        machine.setID(1L);
        machine.setDescription("blah");
        machine.setName("Ruairidh");
        machineList.add(machine);
        machineRepository.saveAndFlush(machine);

        List<ExerciseMachine> exerciseMachineList = new ArrayList<>();
        ExerciseMachine exerciseMachine = new ExerciseMachine();
        exerciseMachine.setExercise_id(1L);
        exerciseMachine.setMachine_id(1L);
        exerciseMachineList.add(exerciseMachine);

        when(repository.findAll()).thenReturn(exerciseMachineList);
        assertEquals(exerciseMachineController.getMachines(1L).size(), 0);
    }


    @Test
    public void testGetExercises(){

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise();
        exercise.setDescription("blah");
        exercise.setName("Ruairidh");
        exercise.setID(1L);
        exerciseList.add(exercise);
        when(exerciseRepository.saveAndFlush(exercise)).thenReturn(exercise);

        List<ExerciseMachine> exerciseMachineList = new ArrayList<>();
        ExerciseMachine exerciseMachine = new ExerciseMachine();
        exerciseMachine.setExercise_id(1L);
        exerciseMachine.setMachine_id(1L);
        exerciseMachineList.add(exerciseMachine);

        when(repository.findAll()).thenReturn(exerciseMachineList);
        assertEquals(exerciseMachineController.getExercises(1L).size(), 0);
    }


}
