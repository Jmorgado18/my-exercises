package com.example.joinedtable;

import com.example.mapped.MappedSuperclassEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends MappedSuperclassEntity {
    private double price;

    public Product() {}

    public Product(String name, int age, double price) {
        super(name, age);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
