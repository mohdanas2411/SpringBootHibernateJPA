package com.example.SpringBootFirst.studentHibernate;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@FilterDef(
        name = "sal",
        parameters = @ParamDef(name = "incomeLimit", type = "int")
)
@Filter(
        name = "sal",
        condition = "salary > :incomeLimit"
)
public class Student implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int sid;

    @Column(name = "Student_Name")
    private String sname;

    @Column(name = "Student_Address")
    private String sadd;


    private int salary;

    public Student() {
    }


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSadd() {
        return sadd;
    }

    public void setSadd(String sadd) {
        this.sadd = sadd;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
