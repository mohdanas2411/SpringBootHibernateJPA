package com.example.SpringBootFirst.criteriaAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("api/item/findAll")
    public List<Item> findAll(){
        return itemService.findAllItem();
    }

    @GetMapping("api/item/avgPrice")
    public Double avgPrice(){
       return itemService.avgPrice();
    }

    @GetMapping("api/item/greterThen600")
    public List<Item> greterThen600(){
       return itemService.greterThen600();
    }

    @GetMapping("api/item/groupByPrice")
    public java.util.HashMap<Double, Long> groupByPrice(){
       return itemService.groupByPrice();
    }

    @GetMapping("api/item/nameLike")
    public List<Item> nameLike(){
       return itemService.nameLike();
    }

    @GetMapping("api/item/selectSomeFields")
    public List<Item> selectSomeFields(){
       return itemService.selectSomeFields();
    }
}
