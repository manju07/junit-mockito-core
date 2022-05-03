package com.spring.core.mockito.mockapp;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {

    TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosWithSpring(String user) {
        List<String> retriveToDos = todoService.retriveToDos(user);
        List<String> filterSpringStrings = new ArrayList<String>();
        for (int i = 0; i < retriveToDos.size(); i++)
            if (retriveToDos.get(i).contains("spring"))
                filterSpringStrings.add(retriveToDos.get(i));
        return filterSpringStrings;
    }

    public void deleteTodosNotWithSpring(String user) {
        List<String> retriveToDos = todoService.retriveToDos(user);
        for (int i = 0; i < retriveToDos.size(); i++)
            if (!retriveToDos.get(i).contains("spring"))
                todoService.deleteToDos(retriveToDos.get(i));
    }
}