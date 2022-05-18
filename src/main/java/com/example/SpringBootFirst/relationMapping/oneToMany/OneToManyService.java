package com.example.SpringBootFirst.relationMapping.oneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OneToManyService {

    @Autowired
    private Session session;

    @Transactional
    public DepartmentOneToMany saveOneToMany(){
        Transaction tx = null;
        try {

            TeacherOneToMany teacher = new TeacherOneToMany();
            teacher.setTname("asf");
            teacher.setTsub("java");
            teacher.setTsalary(23421);

            DepartmentOneToMany dept = new DepartmentOneToMany();
            dept.setDname("computer");
            dept.setDhead("fdsa");
            dept.getTeacher().add(teacher);


            tx = session.beginTransaction();
            session.save(dept);
            tx.commit();

            return dept;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

}
