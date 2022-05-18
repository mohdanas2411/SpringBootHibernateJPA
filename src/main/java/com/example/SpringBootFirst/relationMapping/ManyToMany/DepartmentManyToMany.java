package com.example.SpringBootFirst.relationMapping.ManyToMany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DepartmentManyToMany {
    @Id
    @GeneratedValue
    private int did;

    private String dname;

    private String dhead;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "departmentManyToMany")
    private List<TeacherManyToMany> teacherManyToMany = new ArrayList<>();



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

    public List<TeacherManyToMany> getTeacherManyToMany() {
        return teacherManyToMany;
    }

    public void setTeacherManyToMany(List<TeacherManyToMany> teacherManyToMany) {
        this.teacherManyToMany = teacherManyToMany;
    }
}
