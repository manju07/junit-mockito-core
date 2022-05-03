package com.spring.core.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.spring.core.mockito.ConditionCheck;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestConditionCheckParameterized {

    private ConditionCheck conditionCheck;
    private String expected, input;

    public TestConditionCheckParameterized(String input, String expected) {
        this.expected = expected;
        this.input = input;
    }

    @Parameters
    public static List<Object> parameterizedCollection() {
        String data[][] = { { "100", "true" },
                { "1", "true" },
                { "101", "false" } };
        return Arrays.asList(data);
    }

    @Before
    public void setup() {
        System.out.println("setup called");
        conditionCheck = new ConditionCheck();
    }

    @Test
    public void testConditionCheckParameterized_rangeBetween1And100() {
        System.out.println(this.expected + " " + this.input);
        assertEquals(new Boolean(this.expected), conditionCheck.rangeCheck(Integer.parseInt(this.input)));
    }
}