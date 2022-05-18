package com.example.SpringBootFirst;

import com.example.SpringBootFirst.studentHibernate.Student;
import com.example.SpringBootFirst.studentHibernate.StudentService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

@SpringBootApplication
@RestController

public class SpringBootFirstApplication {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFirstApplication.class, args);


    }


    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }


    @Bean
    public org.hibernate.Session getSession() {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();
        return session;
    }


}
