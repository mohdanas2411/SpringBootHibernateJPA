package com.example.SpringBootFirst.test;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Child2 implements Test{
    @Override
    public String  display() {
        System.out.println("Child 2 ");
        return "Child2";
    }
}
