package com.dzoltowski.todoapp.todo.web;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateNewTodoData {
    private String title;
    private String description;
    private LocalDate dueDate;
}
