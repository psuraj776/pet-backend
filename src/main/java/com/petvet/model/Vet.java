package com.petvet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vets")
public class Vet {
    @Id
    private String id;
    private String name;
    private String address;
    private String license;
    private String contactDetails;
    // Getters and Setters
}