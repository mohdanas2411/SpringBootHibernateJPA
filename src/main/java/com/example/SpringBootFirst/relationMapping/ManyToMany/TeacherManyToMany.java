package com.example.SpringBootFirst.relationMapping.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeacherManyToMany {

    //one teacher has many department

    @Id
    @GeneratedValue
    private int id;

    private String tname;

    private String tsub;

    private int tsalary;

    @ManyToMany
    private List<DepartmentManyToMany> departmentManyToMany = new ArrayList<>();


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

    public List<DepartmentManyToMany> getDepartmentManyToMany() {
        return departmentManyToMany;
    }

    public void setDepartmentManyToMany(List<DepartmentManyToMany> departmentManyToMany) {
        this.departmentManyToMany = departmentManyToMany;
    }
}
