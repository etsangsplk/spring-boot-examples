package com.in28minutes.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.in28minutes.springboot.observation.ConcreteTracer;

@SpringBootApplication
public class StudentServicesApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}

    // Required per https://github.com/opentracing-contrib/java-spring-cloud
    @Bean
    public Tracer tracer() {
       Tracer tracer = ConcreteTracer.getTracer("StudentServices");
       //GlobalTracer.register(tracer);
       return tracer;
    }
}
