package com.qa.controllers;import com.qa.models.Exercise;import com.qa.repository.ExerciseRepository;import org.junit.Test;import org.junit.runner.RunWith;import org.mockito.InjectMocks;import org.mockito.Mock;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.context.embedded.LocalServerPort;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.boot.test.web.client.TestRestTemplate;import org.springframework.test.context.junit4.SpringRunner;import java.util.ArrayList;import java.util.List;import static org.junit.Assert.assertEquals;import static org.mockito.Mockito.when;@RunWith(SpringRunner.class)@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)public class ExerciseControllerTest {    @InjectMocks    private ExerciseController exerciseController;    @Mock    private ExerciseRepository repository;    @LocalServerPort    private int port;    @Autowired    private TestRestTemplate restTemplate;    @Test    public void testGetAllExercise() {        List<Exercise> exerciseList = new ArrayList<>();        Exercise exercise = new Exercise();        exercise.setDescription("blah");        exercise.setName("Ruairidh");        exerciseList.add(exercise);        when(repository.findAll()).thenReturn(exerciseList);        assertEquals(exerciseController.listAllExercises().get(0).getName(), "Ruairidh");    }    @Test    public void testGetOneExercise() {        List<Exercise> exerciseList = new ArrayList<>();        Exercise exercise = new Exercise();        exercise.setDescription("blah");        exercise.setName("Ruairidh");        exercise.setMuscleGroup("arm");        exerciseList.add(exercise);        when(repository.findOne(1L)).thenReturn(exercise);        assertEquals(exerciseController.getExercise(1L).getMuscleGroup(), "arm");    }    @Test    public void testDeleteExercise(){        List<Exercise> exerciseList = new ArrayList<>();        Exercise exercise = new Exercise();        exercise.setDescription("blah");        exercise.setName("Ruairidh");        exercise.setTutorial("tut");        exerciseList.add(exercise);        when(repository.findOne(1L)).thenReturn(exercise);        assertEquals(exerciseController.deleteExercise(1L).getTutorial(), "tut");    }    @Test    public void TestAddExercise(){        List<Exercise> exerciseList = new ArrayList<>();        Exercise exercise = new Exercise();        exercise.setDescription("blah");        exercise.setName("Ruairidh");        exercise.setID(1L);        when(repository.saveAndFlush(exercise)).thenReturn(exercise);        assertEquals(exerciseController.addExercise(exercise).getID().toString(), "1");    }    @Test    public void TestUpdateExercise(){        List<Exercise> exerciseList = new ArrayList<>();        Exercise exercise = new Exercise();        exercise.setID(1L);        exercise.setDescription("blah");        exercise.setName("Ruairidh");        exercise.setMuscleGroup("abs");        exercise.setTutorial("tutorial");        exerciseList.add(exercise);        Exercise exercise1 = new Exercise("rory", "arms", "descr", "efe");        when(repository.findOne(1L)).thenReturn(exercise);        assertEquals(exerciseController.updateExercise(exercise1, 1L).getDescription(),  "descr");    }}