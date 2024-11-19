package com.example.tableperclass;

import com.example.mapped.MappedSuperclassEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
//Table Per Class
@Entity
@Table(name = "employees")
public class Employee extends MappedSuperclassEntity {
    private String department;

    public Employee() {}

    public Employee(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
