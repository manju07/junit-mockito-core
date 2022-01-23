package com.spring.core.mockapp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestTodoBusinessImplWithMockitoAnnotations {

    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoBusinessImpl todoBusinessImpl;

    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void TestRetrieveTodosWithSpring_WithMock() {
        when(todoService.retriveToDos("manju")).thenReturn(Arrays.asList("spring boot", " learn spring", "test"));
        List<String> retrieveTodosWithSpring = todoBusinessImpl.retrieveTodosWithSpring("manju");
        assertEquals(2, retrieveTodosWithSpring.size());
    }

    @Test
    public void TestdeleteTodosNotWithSpring_WithMock() {
        given(todoService.retriveToDos("manju")).willReturn(Arrays.asList("spring boot", " learn spring", "test"));
        // when
        todoBusinessImpl.deleteTodosNotWithSpring("manju");
        // then
        verify(todoService, times(1)).deleteToDos(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues(), is(Arrays.asList("test")));
        verify(todoService, atLeast(0)).deleteToDos("spring boot");
        then(todoService).should(times(1)).deleteToDos("test");
        then(todoService).should(never()).deleteToDos("spring boot");
        then(todoService).should(atLeast(0)).deleteToDos("spring boot");
    }
}