package com.proto.setapi.setapi.dto;

import com.proto.setapi.setapi.entity.Task;

import lombok.Data;

@Data
public class CreateTaskDTO {
    private String title;
    private String description;
    private Task.TaskStatus status = Task.TaskStatus.PENDING;
}