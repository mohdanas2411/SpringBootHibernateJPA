package com.example.SpringBootFirst.relationMapping.ManyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DepartmentManyToOne {
    @Id
    @GeneratedValue
    private int did;

    private String dname;

    private String dhead;

    @ManyToOne
    private TeacherManyToOne teacherManyToOne;

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

    public TeacherManyToOne getTeacherManyToOne() {
        return teacherManyToOne;
    }

    public void setTeacherManyToOne(TeacherManyToOne teacherManyToOne) {
        this.teacherManyToOne = teacherManyToOne;
    }
}
