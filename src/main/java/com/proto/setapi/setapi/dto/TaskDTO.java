package com.proto.setapi.setapi.dto;

import lombok.Data;
import java.time.LocalDateTime;

import com.proto.setapi.setapi.entity.Task;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Task.TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}