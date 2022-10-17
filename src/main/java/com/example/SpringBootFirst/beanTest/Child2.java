package com.example.SpringBootFirst.beanTest;

import org.springframework.stereotype.Component;

@Component
public class Child2 implements Test{
    @Override
    public String  display() {
        System.out.println("Child 2 ");
        return "Child2";
    }
}
