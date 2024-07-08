package com.petvet.repository;

import com.petvet.model.Vet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VetRepository extends MongoRepository<Vet, String> {
}