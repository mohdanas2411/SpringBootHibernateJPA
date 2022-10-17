package com.example.SpringBootFirst.criteriaAPI;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private Session session;

    public List<Item> findAllItem() {

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);

        Root<Item> root = criteriaQuery.from(Item.class);
        CriteriaQuery<Item> select = criteriaQuery.select(root);

        TypedQuery<Item> query1 = session.createQuery(criteriaQuery);


        List<Item> resultList = query1.getResultList();
        return resultList;
    }

    public Double avgPrice() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Double> cr = cb.createQuery(Double.class);
        Root<Item> root = cr.from(Item.class);

        cr.select(cb.avg(root.get("itemPrice")));


        return session.createQuery(cr).uniqueResult();

    }

    public List<Item> greterThen600() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = builder.createQuery(Item.class);

        Root<Item> root = cr.from(Item.class);

        cr.select(root).where(builder.gt(root.get("itemPrice"), 600));

        return session.createQuery(cr).setFirstResult(1).setMaxResults(10).list();

    }


    public HashMap<Double, Long> groupByPrice() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> cr = builder.createQuery(Tuple.class);

        Root<Item> root = cr.from(Item.class);

        cr.groupBy(root.get("itemPrice"));
        cr.multiselect(root.get("itemPrice"), builder.count(root));
        List<Tuple> tupleList = session.createQuery(cr).getResultList();

        HashMap<Double, Long> resultMap = new HashMap<>();

        for (Tuple tuple : tupleList) {
            resultMap.put((Double) tuple.get(0),(Long) tuple.get(1));
        }
        return resultMap;
    }



    public List<Item> nameLike() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> cr = builder.createQuery(Item.class);

        Root<Item> root = cr.from(Item.class);

        cr.select(root.get("itemName")).where(builder.like(root.get("itemName"),"X%1"));

        return session.createQuery(cr).getResultList();

    }

    public List<Item> selectSomeFields() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> cr = builder.createQuery(Tuple.class);

        Root<Item> root = cr.from(Item.class);

        cr.multiselect(root.get("itemId"), root.get("itemPrice"));

        List<Tuple> tupleList = session.createQuery(cr).getResultList();

        List<Item> resultList = new ArrayList<>();

        // converting toupleList to Item List
        for (Tuple t : tupleList) {
            Item item = new Item();
            item.setItemId((int)t.get(0));
            item.setItemPrice((Double) t.get(1));
            resultList.add(item);
        }

        return resultList;
    }


}
