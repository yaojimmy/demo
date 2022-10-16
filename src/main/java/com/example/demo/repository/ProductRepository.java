package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCassandraRepository<ProductEntity, Integer> {
}
