package com.example.SpringBootFirst.studentHibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StudentService {
    @Autowired
    private Session session;

    public Student getStuent(int id) {
        Student student = session.get(Student.class, id);
        return student;
    }


    @Transactional
    public Student saveStu() {

        //Transaction tx = null;

        Student student = new Student();
        student.setSname("mohd anas ansari");
        student.setSadd("shaheen bagh");
        student.setSalary(170);
//
//            session.enableFilter("sal")
//                    .setParameter("incomeLimit", 1000);
        try {
            //     tx = session.beginTransaction();
            session.save(student);
            //   tx.commit();
            return student;
        } catch (Exception e) {
            // if (tx != null) tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

//
//        Student student = new Student();
//        student.setSname("mohd anas ansari");
//        student.setSadd("shaheen bagh");
//        student.setSalary(120);
//
//        session.save(student);
//        return student;

    }


    public List<Student> show() {
        Criteria criteria = session.createCriteria(Student.class);
        Projection pro1 = Projections.property("sname");
        criteria.setProjection(pro1);
        criteria.list().stream().forEach(p -> System.out.println(p));


        //or
        System.out.println("or");

        Criteria criteria1 = session.createCriteria(Student.class);

        criteria1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List list = criteria1.setProjection(
                Projections.projectionList()
                        .add(Projections.property("sname"))
                        .add(Projections.property("sid"))
                        .add(Projections.groupProperty("sid")).add(Projections.count("sid"))
        ).list();
        return list;
    }


    public List<Student> showStu() {
        List<Student> students = session.createQuery("from Student")
                .getResultList();

        return students;
    }
}
