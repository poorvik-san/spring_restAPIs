package com.proto.setapi.setapi.controller;

import com.proto.setapi.setapi.dto.CreateTaskDTO;
import com.proto.setapi.setapi.dto.TaskDTO;
import com.proto.setapi.setapi.entity.Task;
import com.proto.setapi.setapi.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    
    private final TaskService taskService;
    
    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/status/{status}")
    public List<TaskDTO> getTasksByStatus(@PathVariable Task.TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }
    
    @PostMapping
    public TaskDTO createTask(@RequestBody CreateTaskDTO task) {
        return taskService.createTask(task);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody CreateTaskDTO taskDetails) {
        try {
            TaskDTO updatedTask = taskService.updateTask(id, taskDetails);
            return ResponseEntity.ok(updatedTask);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        if(taskService.deleteTask(id))
        return ResponseEntity.ok("Task with ID " + id + " was successfully deleted.");
        else
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Task with ID " + id + " not found.");
    }
}