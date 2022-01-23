package com.spring.core.powermockapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * SumOfNumberTest
 */
@RunWith(MockitoJUnitRunner.class)
// @PrepareForTest(Utility.class)
public class SumOfNumberTest {

    @InjectMocks
    SumOfNumbers sumOfNumbers;

    @Mock
    Depedency depedency;

    @Test
    public void testSumNumbers() {
        int[] arr = { 1, 2, 3 };
        when(depedency.getNumbers()).thenReturn(arr);
        // PowerMockito.mockStatic(Utility.class);
        // when(Utility.sumThem(6)).thenReturn(100);
        int result = sumOfNumbers.sumNumbers();
        assertEquals(result, 106);
    }

    @Test
    public void sampleTest() {
        int[] arr = { 1, 2, 3 };
        when(depedency.getNumbers()).thenReturn(arr);
        int result = sumOfNumbers.sumNumbers();
        assertEquals(106, result);
    }
}