package com.spring.core.powermockapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SumOfNumbers
 */
@Component
public class SumOfNumbers {

    Depedency depedency;

    @Autowired
    public SumOfNumbers(Depedency depedency) {
        this.depedency = depedency;
    }

    public int sumNumbers() {
        int arr[] = depedency.getNumbers();
        int sum = 0;
        for (int temp : arr) {
            sum += temp;
        }
        return sum + 100;
        // Utility.sumThem(sum);
    }
}