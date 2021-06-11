package com.poc.springproject.controller;


import com.poc.springproject.entity.TaskEntity;
import com.poc.springproject.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;

    @PostMapping
    public ResponseEntity createTask(@RequestBody TaskEntity task,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(taskService.createTask(task, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Can't create task");
        }
    }

    @PutMapping
    public ResponseEntity completeTask(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(taskService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Can't retrieve task");
        }
    }
}