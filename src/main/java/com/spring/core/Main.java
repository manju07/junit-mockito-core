package com.spring.core;

import com.spring.core.practice.mockito.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class Main {

    @Autowired
    @Qualifier("car")
    private Vehicle vehicle;

    public void testMain() {
        System.out.println("test Main");
        vehicle.vehicleTest();
    } 

}
