package com.example.SpringBootFirst.hibernateCache;

import com.example.SpringBootFirst.CustomResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
@Component
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FirstCall {

    @Autowired
    ProductRepo productRepo;


    public Product firstCall() {
        Product pro = productRepo.findById(130).orElseThrow(() -> new CustomResourceNotFoundException("Not found employee with id : "));
        System.out.println(pro.getProductId());

        return pro;
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product secondCall() {
        Product product = productRepo.findById(130).orElseThrow(() -> new CustomResourceNotFoundException("not found id "));
        System.out.println(product.getProductId());
        System.out.println(product.getProductName());
        return product;
    }
}
