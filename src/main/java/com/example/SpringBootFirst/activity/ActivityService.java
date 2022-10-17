package com.example.SpringBootFirst.activity;

import com.example.SpringBootFirst.HQLpractical.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class ActivityService {
    @Autowired
    private Session session;

    @Autowired
    TeacherRepo activityRepo;


    public void updateTechDept() {

    }

    public List getAll() {
        return activityRepo.findAll();
    }

    Random r = new Random();

    public Teacher saveData() {
        Department department = new Department();
        //  department.setDeptId(r.nextInt(100));
        department.setDeptName("deptEngg" + r.nextInt(100));
        int sal = r.nextInt(10000);
        department.setDeptDefaultSalary(sal);


        Teacher teacher = new Teacher();
        teacher.setTeacherName("Anas" + r.nextInt(100));
        teacher.setTeacherSalary(sal);
        teacher.setDepartment(department);


        activityRepo.save(teacher);

        return teacher;
    }

    @Transactional
    public int UpdateTeacherDept(int tid, String deptName) {
        Query getDeptQuery = session.createQuery("from Department where deptName = :depname");
        getDeptQuery.setParameter("depname", deptName);
        Department d = (Department) getDeptQuery.uniqueResult();
        //  d.setDeptDefaultSalary(333333);

        Query updateTeacherquery = session.createQuery("update Teacher set teacherSalary = :tsal, department = :depObj where teacherId = :tid");
        updateTeacherquery.setParameter("tsal", d.getDeptDefaultSalary());
        updateTeacherquery.setParameter("depObj", d);
        updateTeacherquery.setParameter("tid", tid);

        return updateTeacherquery.executeUpdate();

    }

    //or using Query annotation

    @Autowired
    DepartmentRepo departmentRepo;

    @Transactional
    public int updateTechDepByName(int tid, String deptname) {
        Department dept = departmentRepo.getDeptByName(deptname);
        session.detach(dept);
        dept.setDeptDefaultSalary(1800);

//        dept.setDeptDefaultSalary(2100); //data in heap
//        session.merge(dept); //merge heap data with persistence object data ; condition this detached entity must be a entity previously
        // or
        //session.load(dept,dept.getDeptId());
        //dept.setDeptDefaultSalary(7777);

        session.update(dept);
        dept.setDeptDefaultSalary(878787);


        return activityRepo.updateByDeptName(dept.getDeptDefaultSalary(), dept.getDeptId(), tid);
    }


    @Autowired
    EntityManagerFactory entityManagerFactory;


    public void readUncommittedAndReapetableRead() {
        Transaction t1 = session.beginTransaction();

        Query query = session.createSQLQuery("INSERT INTO user (user_id,user_bal, user_name) VALUES (:val1, :val3 , :val2)");
        query.setParameter("val1", 200);
        query.setParameter("val2", "Anas");
        query.setParameter("val3", 15000);
        query.executeUpdate();


        Query query1 = session.createQuery("update User set userName = :name where userId = :id");
        query1.setParameter("name", "Mohd");
        query1.setParameter("id", 132);
        query1.executeUpdate();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t1.rollback();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
    public List<User> executeTran() {

        // User u = (User) session.createQuery("from User where userId = 133").uniqueResult();
        List<User> from_user = session.createQuery("from User").list();

        from_user.stream().forEach(System.out::println);

        Query query1 = session.createQuery("update User set userName = :name where userId = :id");
        query1.setParameter("name", "Mohd");
        query1.setParameter("id", 132);
        query1.executeUpdate();

        System.out.println("complete");

        return from_user;

    }


    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
    public void readUncommittedLOCKProblem() {
        Session session1 = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        Transaction t1 = session1.beginTransaction();
        //    executeTran();

        System.out.println("in problem");
        for (int i = 133; i < 140; i++) {
            Query query = session1.createSQLQuery("INSERT INTO user (user_id,user_bal, user_name) VALUES (:val1, :val3 , :val2)");
            query.setParameter("val1", i);
            query.setParameter("val2", "Anas");
            query.setParameter("val3", 15000);
            query.executeUpdate();
            System.out.println(i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Query query1 = session.createQuery("update User set userName = :name where userId = :id");
            query1.setParameter("name", "Mohd");
            query1.setParameter("id", i);
            query1.executeUpdate();
        }
        t1.rollback();
    }

}
