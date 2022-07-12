package com.dzoltowski.todoapp.todo.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    @PostMapping("/create")
    public TodoModel createTodo(@RequestBody CreateNewTodoData todoData) {
        return null;
    }

    @DeleteMapping("/delete")
    public String deleteTodo(@RequestParam("id") Long id) {
        return null;
    }
}
