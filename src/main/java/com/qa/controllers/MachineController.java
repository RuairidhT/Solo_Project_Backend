package com.qa.controllers;

import com.qa.models.Machine;
import com.qa.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class MachineController {


    @Autowired
    private MachineRepository repository;

    @RequestMapping(value = "machines", method = RequestMethod.GET)
    public List<Machine> listAllMachines() {
        return repository.findAll();
    }

    @RequestMapping(value = "machines/{id}", method = RequestMethod.GET)
    public Machine getMachine(@PathVariable Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "machines", method = RequestMethod.POST)
    public Machine addMachine(@RequestBody Machine machine) {
        return repository.saveAndFlush(machine);
    }

    @RequestMapping(value = "machines/{id}", method = RequestMethod.DELETE)
    public Machine deleteMachine(@PathVariable Long id) {
        Machine existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }

    @Transactional
    @RequestMapping(value = "machines/{id}", method = RequestMethod.PUT)
    public Machine updateMachine(@RequestBody Machine machine, @PathVariable Long id) {
        Machine machine1 = repository.findOne(id);
        if (machine1 != null) {
            machine1.setMachine(machine);
        }
        return machine1;
    }

}
