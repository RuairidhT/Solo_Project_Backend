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
        assertEquals(workoutController.listAllWorkouts().get(0).getName(), "Ruairidh");
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
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");
        workoutsList.add(workouts);

        when(repository.findOne(1l)).thenReturn(workouts);
        assertEquals(workoutController.deleteWorkout(1l).getName(), "Ruairidh");

    }

    @Test
    public void TestAddWorkout(){

        List<Workouts> workoutsList = new ArrayList<>();
        Workouts workouts = new Workouts();
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");

        when(repository.saveAndFlush(workouts)).thenReturn(workouts);

        assertEquals(workoutController.addWorkout(workouts).getName(), "Ruairidh");
    }

    @Test
    public void TestUpdateWorkout(){

        List<Workouts> workoutsList = new ArrayList<>();
        Workouts workouts = new Workouts();
        workouts.setDescription("blah");
        workouts.setName("Ruairidh");
        workoutsList.add(workouts);

        Workouts workouts1 = new Workouts();
        workouts1.setName("Chris");

        when(repository.findOne(1l)).thenReturn(workouts);
        assertEquals(workoutController.updateWorkout(workouts1, 1l).getName(), "Chris");
    }

}
