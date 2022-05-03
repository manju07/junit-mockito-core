package com.spring.core.config;

import com.spring.core.mockito.model.Car;
import com.spring.core.mockito.model.Vehicle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    Vehicle getVehicle() {
        return new Car();
    }
}
