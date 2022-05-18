package com.example.SpringBootFirst.relationMapping.ManyToOne;

import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeacherManyToOne {

    //one teacher has many department

    @Id
    @GeneratedValue
    private int id;

    private String tname;

    private String tsub;

    private int tsalary;

    @OneToMany(mappedBy = "teacherManyToOne")
    private List<DepartmentManyToOne> departmentManyToOnes = new ArrayList<>();


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

    public List<DepartmentManyToOne> getDepartmentManyToOnes() {
        return departmentManyToOnes;
    }

    public void setDepartmentManyToOnes(List<DepartmentManyToOne> departmentManyToOnes) {
        this.departmentManyToOnes = departmentManyToOnes;
    }
}
