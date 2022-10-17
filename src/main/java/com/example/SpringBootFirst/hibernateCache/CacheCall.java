package com.example.SpringBootFirst.hibernateCache;

import com.example.SpringBootFirst.CustomResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CacheCall {

    @Autowired
    ProductRepo productRepo;

    public Product firstCall1() {
        System.out.println("****** CacheCall1 class *****");
        Product pro = productRepo.findById(130).orElseThrow(() -> new CustomResourceNotFoundException("Not found employee with id : "));
        System.out.println(pro.getProductId());
        return pro;
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    public Product secondCall1() {
        System.out.println("****** CacheCall1 class *****");
        Product product = productRepo.findById(130).orElseThrow(() -> new CustomResourceNotFoundException("not found id "));
        System.out.println(product.getProductId());
        System.out.println(product.getProductName());
        return product;
    }
}
