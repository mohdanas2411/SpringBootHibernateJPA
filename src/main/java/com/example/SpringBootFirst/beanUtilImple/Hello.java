package com.example.SpringBootFirst.beanUtilImple;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class Hello {
    private String an;

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

}
