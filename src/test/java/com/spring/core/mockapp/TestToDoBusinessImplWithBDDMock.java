package com.spring.core.mockapp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import com.spring.core.mockito.mockapp.TodoBusinessImpl;
import com.spring.core.mockito.mockapp.TodoService;

import org.junit.Before;
import org.junit.Test;

public class TestToDoBusinessImplWithBDDMock {

    private TodoService todoService;

    @Before
    public void setup() {
        this.todoService = mock(TodoService.class);
    }

    @Test
    public void TestRetrieveTodosWithSpring_WithBDDMock() {
        // Given
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        given(todoService.retriveToDos("manju")).willReturn(Arrays.asList("spring boot", " learn spring", "test"));

        // When 
        List<String> retrieveTodosWithSpring = todoBusinessImpl.retrieveTodosWithSpring("manju");

        // Then - assertThat
        assertThat(retrieveTodosWithSpring.size(), is(2));
    }
}