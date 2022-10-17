package com.example.SpringBootFirst.relationMapping.oneToOne;

import javax.persistence.*;

@Entity
public class TeacherOnetoOne {


    @Id
    @GeneratedValue
    private int id;

    private String tname;

    private String tsub;

    private int tsalary;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsub() {
        return tsub;
    }

    public void setTsub(String tsub) {
        this.tsub = tsub;
    }

    public int getTsalary() {
        return tsalary;
    }

    public void setTsalary(int tsalary) {
        this.tsalary = tsalary;
    }
}
