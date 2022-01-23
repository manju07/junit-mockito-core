package com.spring.core.powermockapp;

import org.springframework.stereotype.Component;

@Component
public class GetNumbers implements Depedency {
    public int[] getNumbers() {
        return new int[] { 1, 2, 3 };
    }
}