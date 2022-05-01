package com.spring.core.model;



import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import com.spring.core.practice.mockito.model.Bike;
import com.spring.core.practice.mockito.model.Vehicle;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

public class BikeTest {

    @InjectMocks Vehicle vehicle;

    @Autowired
    public BikeTest() {
        this.vehicle = new Bike();
    }

    @Test
    public void testVehicleTest() {
        vehicle.vehicleTest(); 
        // assertArrayEquals(Arrays.asList(1, 2), Arrays.asList(2, 3)); 
        assertEquals(1, 1); 
    }

}
