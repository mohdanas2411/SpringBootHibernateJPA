package com.example.SpringBootFirst.relationMapping.oneToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DepartmentOneToMany {
    @Id
    @GeneratedValue
    private int did;

    private String dname;

    private String dhead;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "teacherOneToMany")
    private List<TeacherOneToMany> teacher = new ArrayList<>();

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDhead() {
        return dhead;
    }

    public void setDhead(String dhead) {
        this.dhead = dhead;
    }

    public List<TeacherOneToMany> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<TeacherOneToMany> teacher) {
        this.teacher = teacher;
    }
}
