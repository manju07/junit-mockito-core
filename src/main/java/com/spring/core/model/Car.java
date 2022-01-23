package com.spring.core.model;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    @Override
    public void vehicleTest() {
        System.out.println("vehicleTest car");
    }
    
}