package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.opentracing.Tracer;

import com.in28minutes.springboot.observation.ConcreteTracer;

@SpringBootApplication
public class StudentServicesApplication {


	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}

    @Bean
    public Tracer tracer() {
       return ConcreteTracer.getTracer("StudentServices");
    }
}
