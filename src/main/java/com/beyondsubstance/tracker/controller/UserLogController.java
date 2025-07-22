package com.beyondsubstance.tracker.controller;

import com.beyondsubstance.tracker.model.UserLog;
import com.beyondsubstance.tracker.repository.UserLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "*")
public class UserLogController {

    @Autowired
    private UserLogRepository repo;

    @GetMapping
    public List<UserLog> getAllLogs() {
        return repo.findAll();
    }

    @PostMapping
    public UserLog createLog(@RequestBody UserLog log) {
        return repo.save(log);
    }

    @DeleteMapping("/{id}")
    public void deleteLog(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
