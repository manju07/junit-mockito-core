package com.spring.core.mockapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

import com.spring.core.practice.mockito.mockapp.TodoBusinessImpl;
import com.spring.core.practice.mockito.mockapp.TodoService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class TestTodoBusinessImplWithMock {

    private TodoService todoService;

    @Before
    public void setup() {
        this.todoService = mock(TodoService.class);
    }

    @Test
    public void TestRetrieveTodosWithSpring_WithMock() {
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        when(todoService.retriveToDos("manju")).thenReturn(Arrays.asList("spring boot", " learn spring", "test"));
        List<String> retrieveTodosWithSpring = todoBusinessImpl.retrieveTodosWithSpring("manju");
        assertEquals(2, retrieveTodosWithSpring.size());
    }

    @Test
    public void TestdeleteTodosNotWithSpring_WithMock() {
        ArgumentCaptor stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        // given
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        given(todoService.retriveToDos("manju")).willReturn(Arrays.asList("spring boot", " learn spring", "test"));
        // when
        todoBusinessImpl.deleteTodosNotWithSpring("manju");
        // then
        verify(todoService, times(1)).deleteToDos(stringArgumentCaptor.capture());
        assertThat( stringArgumentCaptor.getAllValues(), is(Arrays.asList("test")));
        verify(todoService, atLeast(0)).deleteToDos("spring boot");
        then(todoService).should(times(1)).deleteToDos("test");
        then(todoService).should(never()).deleteToDos("spring boot");
        then(todoService).should(atLeast(0)).deleteToDos("spring boot");
    }
}