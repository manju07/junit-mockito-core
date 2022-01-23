package com.spring.core.model;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ControllerTest {
    
    @Test
    public void test1_boolean() {
        assertEquals("true", "true");
    }

    @Test
    public void test2_boolean() {
        assertEquals("true", "true");
    }

    @Test
    public void test3_hashmap() {
        Map hm = new HashMap<>();
        hm.put(1,2);
        assertEquals(hm, hm);
    }

    @Test
    public void test4_hashmap() {
        Map hm = new HashMap<>();
        hm.put(1,2);

        Map hm1 = new HashMap<>();
        hm1 = hm;
        assertEquals(hm, hm1);
    }
}