package com.spring.core.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.validation.constraints.Null;

import com.spring.core.practice.mockito.ConditionCheck;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestConditionCheck {

    ConditionCheck conditionCheck;

    @Before
    public void setup() {
        this.conditionCheck = new ConditionCheck();
        System.out.println("beforeTest");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeTestClass");
    }

    @Test
    public void testRangeCheck_Within1to100() {
        assertTrue(conditionCheck.rangeCheck(90));
        assertTrue(conditionCheck.rangeCheck(1));
        System.out.println("testRangeCheck_Within1to100");
    }

    @Test
    public void testRangeCheck_Above100() {
        assertFalse(conditionCheck.rangeCheck(101));
        System.out.println("testRangeCheck_Above100");
    }

    @Test
    public void testRangeCheck_LessThan1() {
        assertFalse(conditionCheck.rangeCheck(0));
        System.out.println("testRangeCheck_LessThan1");
    }

    @Test
    public void TestRemoveCharsStartsWithA() {
        assertEquals("BBBC", conditionCheck.removeCharsStartsWithA("AAAABBBC"));
        assertEquals("BBBC", conditionCheck.removeCharsStartsWithA("BBBC"));
        System.out.println("TestRemoveCharsStartsWithA");
    }

    @After
    public void afterTest() {
        System.out.println("afterTest");
    }

    @AfterClass
    public static void afterTestClass() {
        System.out.println("afterTestClass");
    }

    @Test
    public void testExpectNullPointerException() {
        int arr[] = { 2, 1, 3, 4 };
        int expected[] = { 1, 2, 3, 4 };
        Arrays.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test(timeout = 1000)
    public void testPerformanceTest() {
        int arr[] = {1, 2, 5, 10, 4, 6, 0};
        for (int i = 0; i < 10000000; i++) {
            arr[0] = arr[0] + 1;
            arr[arr.length - 1] = i;
            arr[arr.length/2 - 1] = i - 2;
            Arrays.sort(arr);
        }
    }
}