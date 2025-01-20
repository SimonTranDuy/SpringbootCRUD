package com.spring.tutor.demo.controllers;

import java.util.List;
import java.util.Optional;

import com.spring.tutor.demo.models.Product;
import com.spring.tutor.demo.repositories.ProductRepository;
import com.spring.tutor.demo.models.ResponseObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping(path = "api/v1/Products")
public class ProductController {
    // DI = Dependency Injection
    // Autowired: auto create an instance of ProductRepository
    @Autowired
    private ProductRepository repository;

    // Get all products
    @GetMapping("")
    // This request is: http://localhost:8080/api/v1/Products
    List<Product> getAllProducts() {
        // You must save this to Database, Now we have H2 DB = In-memory Database
        return repository.findAll();
        // You can also return a request using postman
    }

    // Get detail of a product
    @GetMapping("/{id}")
    // Let's return an object with: data, message, status
    // http://localhost:8080/api/v1/Products/1 => 1 is a Path Variable
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Query product successfully", foundProduct))
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ResponseObject("false", "Cannot find product with id = " + id, ""));

    }

    // Insert new product with POST method
    // Postman: raw, JSON
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        // 2 products must not be the same name!
        List<Product> foundProducts = repository.findByProductName(newProduct.getProductName().trim()); // trim():
                                                                                                        // remove white
                                                                                                        // space
        if (foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                    .body(new ResponseObject("failed", "Product name already taken", ""));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Insert product successfully", repository.save(newProduct)));
    }

    // update, upsert = update if found, insert if not found
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updateProduct = repository.findById(id).map(product -> {
            product.setProductName(newProduct.getProductName());
            product.setproductYear(newProduct.getproductYear());
            product.setPrice(newProduct.getPrice());
            return repository.save(product);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return repository.save(newProduct);
        });
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("ok", "Update product successfully", updateProduct));
    }

    // Delete a product => DELETE method
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("ok", "Delete product successfully", ""));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ResponseObject("failed", "Cannot find product to delete", ""));
    }

    // Delete all products
    @DeleteMapping("/deleteAll")
    ResponseEntity<ResponseObject> deleteAllProducts() {
        repository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Delete all products successfully", ""));
    }

}
