package com.dzoltowski.todoapp.todo.utils;

import com.dzoltowski.todoapp.todo.domain.Todo;
import com.dzoltowski.todoapp.todo.persistance.TodoEntity;
import com.dzoltowski.todoapp.todo.web.CreateNewTodoData;
import com.dzoltowski.todoapp.todo.web.TodoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo mapToDomain(TodoEntity todoEntity);

    @Mapping(target = "id", ignore = true)
    TodoEntity mapToEntity(Todo todo);

    TodoModel mapToModel(Todo todo);

    Todo mapToDomainFromModel(TodoModel todoModel);

    @Mapping(target = "id", ignore = true)
    Todo mapToDomainFromCreateData(CreateNewTodoData newTodoData);

    @Mapping(target = "id", ignore = true)
    TodoEntity mapToEntityFromCreateData(CreateNewTodoData newTodoData);
}
