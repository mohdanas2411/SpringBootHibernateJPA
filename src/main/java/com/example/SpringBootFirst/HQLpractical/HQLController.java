package com.example.SpringBootFirst.HQLpractical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HQLController {

    @Autowired
    private UserService userService;



    @GetMapping("api/hql/getallusers")
    public ResponseEntity getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());

    }

    @GetMapping("api/hql/getBalance")
    public ResponseEntity getBalance(){
        return ResponseEntity.ok(userService.getBalance());
    }

    @GetMapping("api/hql/getBalanceGt500")
    public ResponseEntity getBalanceGt500(){
        return ResponseEntity.ok(userService.getBalanceGt500());
    }

    @GetMapping("api/hql/orderbyBal")
    public ResponseEntity orderbyBal(){
        return ResponseEntity.ok(userService.orderbyBal());
    }

    @GetMapping("api/hql/groupbyname")
    public ResponseEntity groupbyname(){
        return ResponseEntity.ok(userService.groupbyname());
    }

    @GetMapping("api/hql/groupbybal")
    public ResponseEntity groupbybal(){
        return ResponseEntity.ok(userService.groupbybal());
    }

    @GetMapping("api/hql/sumOfbal")
    public Long sumOfbal(){
        return userService.sumOfbal();
    }

    @GetMapping("api/hql/findById")
    public ResponseEntity findById(){
        return ResponseEntity.ok(userService.findById());
    }

    @GetMapping("api/hql/fetchStartandEnd")
    public ResponseEntity fetchStartandEnd(){
        return ResponseEntity.ok(userService.fetchStartandEnd());
    }


}
