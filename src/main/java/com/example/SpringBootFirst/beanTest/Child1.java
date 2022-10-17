package com.example.SpringBootFirst.beanTest;

import org.springframework.stereotype.Component;

@Component("hello")
public class Child1 implements Test{
    @Override
    public String display() {
        System.out.println("Child 1 ");
        return "Child1";
    }

}
