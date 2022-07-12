package com.dzoltowski.todoapp.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class Todo {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;

}
