package com.qa.controllers;

import com.qa.models.Machine;
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
public class MachineControllerTest {

    @InjectMocks
    private MachineController machineController;

    @Mock
    private MachineRepository repository;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testGetAllMachines() {

        List<Machine> machineList = new ArrayList<>();
        Machine machine = new Machine();
        machine.setDescription("blah");
        machine.setName("Ruairidh");
        machineList.add(machine);

        when(repository.findAll()).thenReturn(machineList);
        assertEquals(machineController.listAllMachines().get(0).getDescription(), "blah");
    }

    @Test
    public void testGetOneMachine() {

        List<Machine> machineList = new ArrayList<>();
        Machine machine = new Machine();
        machine.setDescription("blah");
        machine.setName("Ruairidh");
        machineList.add(machine);

        when(repository.findOne(1L)).thenReturn(machine);
        assertEquals(machineController.getMachine(1L).getName(), "Ruairidh");
    }

    @Test
    public void testDeleteMachine(){

        List<Machine> machineList = new ArrayList<>();
        Machine machine = new Machine();
        machine.setID(1L);
        machine.setDescription("blah");
        machine.setName("Ruairidh");
        machineList.add(machine);

        when(repository.findOne(1L)).thenReturn(machine);
        assertEquals(machineController.deleteMachine(1L).getID().toString(), "1");

    }

    @Test
    public void TestAddMachine(){

        List<Machine> machineList = new ArrayList<>();
        Machine machine = new Machine();
        machine.setDescription("blah");
        machine.setName("Ruairidh");
        machineList.add(machine);
        when(repository.saveAndFlush(machine)).thenReturn(machine);

        assertEquals(machineController.addMachine(machine).getDescription(), "blah");
    }

    @Test
    public void TestUpdateMachine(){

        List<Machine> machineList = new ArrayList<>();
        Machine machine = new Machine();
        machine.setID(1L);
        machine.setDescription("blah");
        machine.setName("Ruairidh");
        machineList.add(machine);

        Machine machine1 = new Machine("rory", "test");

        when(repository.findOne(1L)).thenReturn(machine);
        assertEquals(machineController.updateMachine(machine1, 1L).getName(), "rory");
    }

}
