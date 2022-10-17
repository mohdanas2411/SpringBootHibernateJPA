package com.example.SpringBootFirst;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

    @Autowired
    TE te;

    @Autowired Hello h;


    @GetMapping("demo")
    public String demo(){
        B b = new B();
        b.setMsg("change");
        Hello h1 = te.hello1(b);

        BeanUtils.copyProperties(h1,h);


        return "Updated :  "+ h1.getAn();
    }

    @GetMapping("msg1")
    public String msg1(){
        return h.getAn();
    }


//    @GetMapping("msg2")
//    public String msg2(){
//        return h.getAn();
//    }
}
