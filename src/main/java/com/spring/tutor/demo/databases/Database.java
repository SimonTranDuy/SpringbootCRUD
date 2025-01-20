package com.spring.tutor.demo.databases;

import com.spring.tutor.demo.models.Product;

import com.spring.tutor.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Initialize data for H2 Database
// Now connect with mySQL using JPA
/*
// Start mysql container
docker run -d --rm --name mysql-spring-boot-tutorial -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test_db -p 3309:3306 --volume mysql-spring-boot-tutorial-volume:/var/lib/mysql mysql:latest           

// Check container
docker ps

// Connect to mysql container
docker exec -it mysql-spring-boot-tutorial mysql -uroot -p   //-h: host //-P: port //--protocol: tcp

// acces to test_db
use test_db;

// show tables
show tables;

// show data
select * from tbl_product;
*/
// Configuration class: manage beans
@Configuration
public class Database {
    // Logger: print log
    private final Logger logger = LoggerFactory.getLogger(Database.class);

    // Bean: manage objects
    // @Bean
    // CommandLineRunner initDatabase(ProductRepository productRepository) {
    //     // return new CommandLineRunner() {
    //     //     @Override
    //     //     public void run(String... args) throws Exception {
    //     //         Product productA = new Product("Macbook Pro 16 inch", 2020, 2400, "");
    //     //         Product productB = new Product("Ipad Air Green", 2021, 599.0, "");
    //     //         logger.info("insert data: " + productRepository.save(productA));
    //     //         logger.info("insert data: " + productRepository.save(productB));
    //     //     }
    //     // };
    // }

}
