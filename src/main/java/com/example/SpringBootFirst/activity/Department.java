package com.example.SpringBootFirst.activity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int deptId;

    private String deptName;

    private double deptDefaultSalary;

    public Department() {
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public double getDeptDefaultSalary() {
        return deptDefaultSalary;
    }

    public void setDeptDefaultSalary(double deptDefaultSalary) {
        this.deptDefaultSalary = deptDefaultSalary;
    }
}
