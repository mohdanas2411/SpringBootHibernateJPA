package com.example.SpringBootFirst.hqlpractical;

import org.apache.catalina.LifecycleState;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private Session session;


    public List<User> getAllUsers() {
        Query from_user = session.createQuery("from User AS data");
        List list = from_user.list();
        list.forEach(us -> System.out.println(us));
        return list;
    }

    public List<User> getBalance(){
        Query select_userBal_from_user = session.createQuery("Select userBal from User");
        List list = select_userBal_from_user.list();
        return list;
    }

    public List<User> getBalanceGt500(){
        Query query = session.createQuery("from User where userBal > 500");
        return query.list();
    }

    public List<User> orderbyBal(){
        return session.createQuery("from User U where userId>140 order By U.userBal").list();
    }

    public List<User> groupbyname(){
        return session.createQuery("select SUM(userBal) , userName from User U group by userName").list();
    }

    public List<User> groupbybal(){
        return session.createQuery("select SUM(userBal) from User U group by userBal").list();
    }

    public long sumOfbal(){
        return (long) session.createQuery("select sum(userBal) from User").uniqueResult();
    }

    public User findById(){
        Query query = session.createQuery("from User where userId = :id");
        query.setParameter("id",140);
        return (User) query.uniqueResult();
    }


    public List<User> fetchStartandEnd(){
        Query query = session.createQuery("from User");
        query.setFirstResult(4);
        query.setMaxResults(7);
        return query.list();
    }
}
