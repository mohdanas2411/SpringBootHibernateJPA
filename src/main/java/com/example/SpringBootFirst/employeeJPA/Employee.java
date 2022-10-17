package com.example.SpringBootFirst.employeeJPA;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    private static Log log = LogFactory.getLog(Employee.class);

    @Id
    @GeneratedValue()
    private int id;

    private String name;
    private String address;

    @Transient
    private String fullname = "hey";

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @PostLoad
    public void print(){
        log.info("in database emp name"+ name);
    }
}
