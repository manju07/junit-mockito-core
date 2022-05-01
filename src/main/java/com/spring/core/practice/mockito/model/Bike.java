package com.spring.core.practice.mockito.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Bike implements Vehicle {

    @Override
    public void vehicleTest() {
        System.out.println("vehicleTest bike");
    }
    
}