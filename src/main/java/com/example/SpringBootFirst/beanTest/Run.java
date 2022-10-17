package com.example.SpringBootFirst.beanTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Run {
//    @Autowired
//    @Qualifier("hello")
//    Test chi;

    @Autowired
    @Qualifier("hello")
    Test chi;


    @GetMapping("api/test")
    public ResponseEntity display() {
        return ResponseEntity.ok(chi.display());
    }

}
