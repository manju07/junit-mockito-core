package com.spring.core;

import org.springframework.stereotype.Component;

@Component
public class ConditionCheck {

    public Boolean rangeCheck(int data) {
        return data > 0 && data <= 100;
    }

    public String removeCharsStartsWithA(String string) {
        if (string.length() == 0 || string == null)
            return null;
        return string.substring(string.lastIndexOf("A") + 1);
    }
}