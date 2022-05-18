package com.example.SpringBootFirst.relationMapping.ManyToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManyToOneService {

    @Autowired
    private Session session;

    @Transactional
    public DepartmentManyToOne saveManyToOne(){
        Transaction tx = null;
        try {


            DepartmentManyToOne dept = new DepartmentManyToOne();
            dept.setDname("computer");
            dept.setDhead("fdsa");


            TeacherManyToOne teacher = new TeacherManyToOne();
            teacher.setTname("asf");
            teacher.setTsub("java");
            teacher.setTsalary(23421);
            teacher.getDepartmentManyToOnes().add(dept);


            tx = session.beginTransaction();
            session.save(teacher);
            tx.commit();

            return dept;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

}
