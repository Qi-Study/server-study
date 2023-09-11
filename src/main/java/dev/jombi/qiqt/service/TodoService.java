package dev.jombi.qiqt.service;

import dev.jombi.qiqt.entity.TodoEntity;
import dev.jombi.qiqt.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoEntity addTodo(String content) {
        TodoEntity entity = TodoEntity.builder()
                .content(content)
                .success(false)
                .build();

        return repository.save(entity);
    }

    public List<TodoEntity> todoList() {
        List<TodoEntity> todos = repository.findAll();
        return todos;
    }

    public boolean markTodo(int todoId, boolean isSuccess) {
        if (!repository.existsById(todoId))
            return false;

        int success = repository.editTodoMark(todoId, isSuccess);
        return success == 0; // success = 0 -> true
    }
}
