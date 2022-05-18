package com.example.SpringBootFirst.relationMapping.oneToOne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OneToOneService {

    @Autowired
    private Session session;

    @Transactional
    public DepartmentOneToOne saveOnetoOne(){
        Transaction tx = null;
        try {

            TeacherOnetoOne teacher = new TeacherOnetoOne();
            teacher.setTname("asf");
            teacher.setTsub("java");
            teacher.setTsalary(23421);

            DepartmentOneToOne dept = new DepartmentOneToOne();
            dept.setDname("computer");
            dept.setDhead("fdsa");
            dept.setTeacher(teacher);

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
