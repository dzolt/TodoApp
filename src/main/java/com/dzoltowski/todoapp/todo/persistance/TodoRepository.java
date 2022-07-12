package com.dzoltowski.todoapp.todo.persistance;

import com.dzoltowski.todoapp.todo.domain.Todo;
import com.dzoltowski.todoapp.todo.utils.TodoMapper;
import com.dzoltowski.todoapp.todo.web.CreateNewTodoData;
import com.dzoltowski.todoapp.user.persistance.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TodoRepository {

    private final TodoJpaRepository jpaRepository;
    private final UserRepository userRepository;
    private final TodoMapper mapper;

    public Todo saveNewTodo(CreateNewTodoData newTodoData, String username) {
        TodoEntity todoEntity = mapper.mapToEntityFromCreateData(newTodoData);
        todoEntity.setOwner(userRepository.getUserEntityByUserName(username));

        return mapper.mapToDomain(jpaRepository.save(todoEntity));
    }
}
