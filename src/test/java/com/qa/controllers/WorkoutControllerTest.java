package com.qa.controllers;

import com.qa.models.Workouts;
import com.qa.repository.WorkoutRepository;
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
public class WorkoutControllerTest {

    @InjectMocks
    private WorkoutController workoutController;

    @Mock
    private WorkoutRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testGetAllWorkout() {

        List<Workouts> workoutsList = new ArrayList<>();
        Workouts workouts = new Workouts();
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");
        workoutsList.add(workouts);

        when(repository.findAll()).thenReturn(workoutsList);
        assertEquals(workoutController.listAllWorkouts().get(0).getDescription(), "blah");
    }

    @Test
    public void testGetOneWorkout() {

        List<Workouts> workoutsList = new ArrayList<>();
        Workouts workouts = new Workouts();
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");
        workoutsList.add(workouts);

        when(repository.findOne(1l)).thenReturn(workouts);
        assertEquals(workoutController.getWorkout(1l).getName(), "Ruairidh");
    }

    @Test
    public void testDeleteWorkout(){

        List<Workouts> workoutsList = new ArrayList<>();
        Workouts workouts = new Workouts();
        workouts.setID(1l);
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");
        workoutsList.add(workouts);

        when(repository.findOne(1l)).thenReturn(workouts);
        assertEquals(workoutController.deleteWorkout(1l).getID().toString(), "1");

    }

    @Test
    public void TestAddWorkout(){

        List<Workouts> workoutsList = new ArrayList<>();
        Workouts workouts = new Workouts();
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");
        workouts.setTutorial("tutorial");
        when(repository.saveAndFlush(workouts)).thenReturn(workouts);

        assertEquals(workoutController.addWorkout(workouts).getTutorial(), "tutorial");
    }

    @Test
    public void TestUpdateWorkout(){

        List<Workouts> workoutsList = new ArrayList<>();
        Workouts workouts = new Workouts();
        workouts.setID(1l);
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");
        workouts.setMuscleGroup("abs");
        workouts.setTutorial("tutorial");
        workoutsList.add(workouts);

        Workouts workouts1 = new Workouts("rory", "arms", "descr", "efe");

        when(repository.findOne(1l)).thenReturn(workouts);
        assertEquals(workoutController.updateWorkout(workouts1, 1l).getMuscleGroup(), "arms");
    }

}
