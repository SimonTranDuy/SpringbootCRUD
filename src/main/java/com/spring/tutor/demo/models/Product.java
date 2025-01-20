package com.spring.tutor.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// import jakarta.persistence.SequenceGenerator;
// import jakarta.persistence.GeneratedValue;

import java.util.Calendar;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;

//POJO = Plain Old Java Object
@Entity
@Table(name = "tblProduct")
public class Product {
    // This is primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto increment
    // You can also use Sequence
    // @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Long id;
    // // validate = constraint
    @Column(nullable = false, unique = true, length = 300)
    private String productName;
    private int productYear;
    private double price;
    private String url;

    // Default constructor
    public Product() {
    }

    // Calculated field = transient, not exist in database
    @Transient // Not save to database
    private int age; // age is calculated from "year"

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - productYear;
    }

    public Product(String productName, int productYear, double price, String url) {
        this.productName = productName;
        this.productYear = productYear;
        this.price = price;
        this.url = url;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getproductYear() {
        return productYear;
    }

    public double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setproductYear(int productYear) {
        this.productYear = productYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productYear=" + productYear +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product product = (Product) obj;
        return productYear == product.productYear && age == product.age
                && Objects.equals(productName, product.productName)
                && Objects.equals(price, product.price) && Objects.equals(url, product.url);
    }
}
