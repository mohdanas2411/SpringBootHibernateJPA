package com.example.SpringBootFirst.hibernateCache;

import com.example.SpringBootFirst.CustomResourceNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceProperty;

@Service
@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ProductService {
    @Autowired
    private Session session;
    @Autowired
    private EntityManagerFactory entityManagerFactory;


//    @PersistenceContext(type = javax.persistence.PersistenceContextType.TRANSACTION,
//            properties = @PersistenceProperty(name="org.hibernate.flushMode", value="COMMIT"))
    @Autowired
    protected EntityManager entityManager;

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    CacheCall call1;

    @Autowired
    CacheCall2 call2;



    public void getCall(){
        call1.firstCall1();
        call1.secondCall1();
    }
    public void getCall2(){
        call2.firstCall();
        call2.secondCall();
    }
    public void firstLevelCache() {

        //first session
        System.out.println("*********** session 1 ************");
        Transaction t1 = session.beginTransaction();

//        List<Product> list1 = session.createQuery("From Product").list();
//        System.out.println("call first from list 1 " + list1.get(0).getProductId());
        System.out.println("********* tx1 ******");
        Product product1 = session.get(Product.class, 132);

        System.out.println("call first from Product1 132 : " + product1.getProductId());
        System.out.println("call first from Product1 id 132 price : " + product1.getProductPrice());
       // product1.setProductPrice(44444);

        t1.commit();

        Transaction t5 = session.beginTransaction();
        System.out.println("********* tx2 ******");
        Product product6 = session.get(Product.class, 132);
        System.out.println("call first from Product1 132 : " + product6.getProductId());
        System.out.println("call first from Product1 id 132 price : " + product6.getProductPrice());
        t5.commit();


       // session.close();
        System.out.println("88888888888888   session closed 9999999999");
    //    session = sessionFactory.openSession();
        Transaction t3 = session.beginTransaction();
        Product product2 = session.get(Product.class, 130);
        System.out.println("call second from Product1 130 : " + product2.getProductId());

        t3.commit();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Transaction t2 = session.beginTransaction();
//        List<Product> list2 = session.createQuery("From Product").list();
//        System.out.println("call second from list 2 " + list2.get(0).getProductId());

        Product product3 = session.get(Product.class, 132);
        System.out.println("call second from Product2 132 : " + product3.getProductId());
        t2.commit();


        //second session
        System.out.println("*********** session 2 ************");
        Session session1 = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        Product product4 = session1.get(Product.class, 132);
        System.out.println("call first session 2 from Product4 for 128 - 132 : " + product4.getProductId());

    }


  //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product firstCall() {
        Product pro = null;
               pro=  productRepo.findById(130).orElseThrow(() -> new CustomResourceNotFoundException("Not found employee with id : "));
        System.out.println(pro.getProductId());
        System.out.println(entityManager);
         //secondCall();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        session = sessionFactory.getCurrentSession();
//        Transaction t1 = session.beginTransaction();
//        Product product1 = session.get(Product.class, 132);
//        System.out.println("call first from Product1 132 : " + product1.getProductId());
//
//        t1.commit();

        return pro;
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product secondCall() {
        Product product = productRepo.findById(130).orElseThrow(() -> new CustomResourceNotFoundException("not found id "));
        System.out.println(product.getProductId());
        System.out.println(product.getProductName());

//        session = sessionFactory.getCurrentSession();
//        Transaction t1 = session.beginTransaction();
//        Product product1 = session.get(Product.class, 132);
//        System.out.println("call second from Product1 132 : " + product1.getProductId());
//
//        t1.commit();



        return product;
    }

//    @Override
//    public Session currentSession() throws HibernateException {
//        return session;
//    }
}
