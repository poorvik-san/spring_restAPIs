package com.proto.setapi.setapi.service;

import com.proto.setapi.setapi.dto.CreateTaskDTO;
import com.proto.setapi.setapi.dto.TaskDTO;
import com.proto.setapi.setapi.entity.Task;
import com.proto.setapi.setapi.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    
    private final TaskRepository taskRepository;
    
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }
    
    public Optional<TaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(this::toDTO);
    }
    
    public List<TaskDTO> getTasksByStatus(Task.TaskStatus status) {
        return taskRepository.findByStatus(status).stream()
                .map(this::toDTO)
                .toList();
    }
    
    public TaskDTO createTask(CreateTaskDTO createTaskDTO) {
        Task task = toEntity(createTaskDTO);
        Task savedTask = taskRepository.save(task);
        return toDTO(savedTask);
    }
    
    public TaskDTO updateTask(Long id, CreateTaskDTO taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        
        Task updatedTask = taskRepository.save(task);
        return toDTO(updatedTask);
    }
    
    public boolean deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
        catch (Exception e) {
            return false;
        }
    }
    
    private TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());
        return dto;
    }
    
    private Task toEntity(CreateTaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        return task;
    }
}