// PetVetApplication.java
package com.petvet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetVetApplication {
    private static final Logger logger = LoggerFactory.getLogger(PetVetApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(PetVetApplication.class, args);
	logger.info("Application started successfully!");
    }
}
