package com.example.SpringBootFirst.relationMapping.ManyToMany;

import com.example.SpringBootFirst.relationMapping.ManyToOne.DepartmentManyToOne;
import com.example.SpringBootFirst.relationMapping.ManyToOne.TeacherManyToOne;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ManyToManyService {

    @Autowired
    private Session session;

    @Transactional
    public DepartmentManyToMany saveManyToMany(){
        Transaction tx = null;
        try {


            DepartmentManyToMany dept = new DepartmentManyToMany();
            dept.setDname("computer");
            dept.setDhead("fdsa");


            TeacherManyToMany teacher = new TeacherManyToMany();
            teacher.setTname("asf");
            teacher.setTsub("java");
            teacher.setTsalary(23421);
            teacher.getDepartmentManyToMany().add(dept);

            dept.getTeacherManyToMany().add(teacher);


            tx = session.beginTransaction();
            session.save(teacher);
            session.save(dept);
            tx.commit();

            return dept;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

}
