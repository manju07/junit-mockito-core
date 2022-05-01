package com.spring.core.practice.config;

import com.spring.core.practice.mockito.model.Car;
import com.spring.core.practice.mockito.model.Vehicle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    Vehicle getVehicle() {
        return new Car();
    }
}
