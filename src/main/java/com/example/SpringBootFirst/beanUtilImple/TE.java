package com.example.SpringBootFirst;

import org.springframework.beans.factory.annotation.Autowired;
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
