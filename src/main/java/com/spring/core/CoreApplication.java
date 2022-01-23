package com.spring.core;

import com.spring.core.config.Config;
import com.spring.core.model.Vehicle;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @SpringBootApplication
public class CoreApplication {

	// @Autowired
	// @Qualifier("car")
	// private Vehicle vehicle;

	public static void main(String[] args) {
		// ConfigurableApplicationContext context = SpringApplication.run(CoreApplication.class, args);
		// ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		// AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class)
		// // Main main = (Main) beanFactory.getBean("main");
		// Main main = (Main) context2.getBean("main");
		// main.testMain();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("file:/Users/ma/Manju/core/src/main/java/com/spring/core/Test.xml");
		// Testing test = context.getBean("test1", Testing.class);
		// Testing test1 = context.getBean("test2", Testing.class);
		// test.testMethod();
		// test1.testMethod();
		// Vehicle carObject = test1.getCarObject();
		// carObject.vehicleTest();
	}
}