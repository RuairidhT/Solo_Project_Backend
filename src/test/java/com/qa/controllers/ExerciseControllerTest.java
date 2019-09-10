package com.qa.controllers;

import com.qa.models.Exercise;
import com.qa.models.Workouts;
import com.qa.repository.ExerciseRepository;
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
public class ExerciseControllerTest {

    @InjectMocks
    private ExerciseController exerciseController;

    @Mock
    private ExerciseRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testGetAllWorkout() {

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise();
        exercise.setDescription("blah");
        exercise.setName("Ruairidh");
        exerciseList.add(exercise);

        when(repository.findAll()).thenReturn(exerciseList);
        assertEquals(exerciseController.listAllExercises().get(0).getName(), "Ruairidh");
    }

    @Test
    public void testGetOneWorkout() {

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise();
        exercise.setDescription("blah");
        exercise.setName("Ruairidh");
        exerciseList.add(exercise);

        when(repository.findOne(1l)).thenReturn(exercise);
        assertEquals(exerciseController.getExercise(1l).getName(), "Ruairidh");
    }

    @Test
    public void testDeleteWorkout(){

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise();
        exercise.setDescription("blah");
        exercise.setName("Ruairidh");
        exerciseList.add(exercise);

        when(repository.findOne(1l)).thenReturn(exercise);
        assertEquals(exerciseController.deleteExercise(1l).getName(), "Ruairidh");

    }

    @Test
    public void TestAddWorkout(){

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise();
        exercise.setDescription("blah");
        exercise.setName("Ruairidh");

        when(repository.saveAndFlush(exercise)).thenReturn(exercise);

        assertEquals(exerciseController.addExercise(exercise).getName(), "Ruairidh");
    }

    @Test
    public void TestUpdateWorkout(){

        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise();
        exercise.setDescription("blah");
        exercise.setName("Ruairidh");
        exerciseList.add(exercise);

        Exercise exercise1 = new Exercise();
        exercise1.setName("Chris");

        when(repository.findOne(1l)).thenReturn(exercise);
        assertEquals(exerciseController.updateExercise(exercise1, 1l).getName(), "Chris");
    }

}
