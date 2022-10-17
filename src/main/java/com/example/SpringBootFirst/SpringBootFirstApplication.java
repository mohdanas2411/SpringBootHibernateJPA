package com.example.SpringBootFirst;

import com.example.SpringBootFirst.employeeJPA.RestTemplateModificationInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@EnableCaching
public class SpringBootFirstApplication {

    @Autowired
    EntityManagerFactory entityManagerFactory;

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
    @Bean
    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }




//    @Bean(name = "transactionManager")
//    public JpaTransactionManager getTransactionManager() {
//        JpaTransactionManager tm = new JpaTransactionManager();
//
//        tm.setEntityManagerFactory(entityManagerFactory);
//        return tm;
//    }

//    @Bean(name = "transactionManager")
//    public Transaction getTransaction(){
//        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
//        Transaction transaction = session.beginTransaction();
//        return transaction;
//    }


}
