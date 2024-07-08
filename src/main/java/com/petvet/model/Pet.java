// Pet.java
package com.petvet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pets")
public class Pet {
    @Id
    private String id;
    private String name;
    private String breed;
    private String vetId; // Reference to Vet
    // Getters and Setters
}