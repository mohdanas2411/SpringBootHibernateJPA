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

@Service
@EnableTransactionManagement
@Transactional
public class StudentService {
    @Autowired
    private Session session;

    @Transactional
    public Student getStuent(int id) {
        Student student = session.get(Student.class, id);
        return student;
    }

    @Transactional
    public Student saveStu() {

        Transaction tx = null;
        try {

            Student student = new Student();
            student.setSname("mohd anas ansari");
            student.setSadd("shaheen bagh");
            student.setSalary(170);

            session.enableFilter("sal")
                    .setParameter("incomeLimit", 1000);

            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
            return student;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
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


    public void show() {
        Criteria criteria = session.createCriteria(Student.class);
        Projection pro1 = Projections.property("sname");
        criteria.setProjection(pro1);
        criteria.list().stream().forEach(p -> System.out.println(p));


        //or
        System.out.println("or");

        Criteria criteria1 = session.createCriteria(Student.class);
        List list = criteria1.setProjection(
                Projections.projectionList()
                        .add(Projections.property("sname"))
                        .add(Projections.property("sid"))
                        .add(Projections.groupProperty("sid")).add(Projections.count("sid"))
        ).list();
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            Object obj = iterator.next();
//                if (obj instanceof String[]) {
//                    String[] strArray = (String[]) obj;
//                    System.out.println(Arrays.toString(strArray));
//                     System.out.println(obj);
//                    System.out.println(((String[]) obj).length);
//                }
//        }


    }


    public List<Student> showStu(){
        List<Student> students = session.createQuery("from Student")
                .getResultList();

        return students;
    }
}
