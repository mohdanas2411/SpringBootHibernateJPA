package com.example.SpringBootFirst.hibernateCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/api/acti/firstLevelCache")
    public void firstLevelCache() {
        productService.firstLevelCache();
    }

    @GetMapping("/api/acti/firstCall")
    public Product firstCall() {
      //  productService.secondCall();
        return productService.firstCall();
    }

    @GetMapping("/api/acti/secondCall")
    public Product secondCall() {

        return productService.secondCall();
    }

    @GetMapping("/api/acti/call")
    public void call() {

         productService.getCall();
         productService.getCall2();
    }
}
