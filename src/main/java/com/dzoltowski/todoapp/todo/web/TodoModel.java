package com.dzoltowski.todoapp.todo.web;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoModel {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
}
