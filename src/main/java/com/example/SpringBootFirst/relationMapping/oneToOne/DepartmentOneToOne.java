package com.example.SpringBootFirst.relationMapping.oneToOne;

import javax.persistence.*;

@Entity
public class DepartmentOneToOne {
    @Id
    @GeneratedValue
    private int did;

    private String dname;

    private String dhead;

    @OneToOne(cascade = {CascadeType.ALL})
    private TeacherOnetoOne teacher;

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

    public TeacherOnetoOne getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherOnetoOne teacher) {
        this.teacher = teacher;
    }
}
