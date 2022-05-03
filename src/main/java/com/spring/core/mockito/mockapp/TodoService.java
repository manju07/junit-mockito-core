package com.spring.core.mockito.mockapp;

import java.util.List;

public interface TodoService {
    public List<String> retriveToDos(String user);
    public void deleteToDos(Object object);
}
