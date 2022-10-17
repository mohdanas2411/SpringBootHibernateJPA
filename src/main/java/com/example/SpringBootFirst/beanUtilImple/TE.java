package com.example.SpringBootFirst.beanUtilImple;

import com.example.SpringBootFirst.beanUtilImple.B;
import com.example.SpringBootFirst.beanUtilImple.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TE {


    @Bean
    public Hello hello1(B a) {
        Hello hello = new Hello();
        hello.setAn(a.getMsg());
        return hello;
    }
}
