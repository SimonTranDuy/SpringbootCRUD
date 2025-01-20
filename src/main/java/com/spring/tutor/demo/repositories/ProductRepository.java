package com.spring.tutor.demo.repositories;

import java.util.List;

import com.spring.tutor.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Respository: manage data
//JpaRespository <Entity, Primary Key Type>
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductName(String productName);
}
