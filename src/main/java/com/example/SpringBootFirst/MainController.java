package com.example.SpringBootFirst;

import com.example.SpringBootFirst.relationMapping.ManyToMany.DepartmentManyToMany;
import com.example.SpringBootFirst.relationMapping.ManyToMany.ManyToManyService;
import com.example.SpringBootFirst.relationMapping.ManyToOne.DepartmentManyToOne;
import com.example.SpringBootFirst.relationMapping.ManyToOne.ManyToOneService;
import com.example.SpringBootFirst.relationMapping.oneToMany.DepartmentOneToMany;
import com.example.SpringBootFirst.relationMapping.oneToMany.OneToManyService;
import com.example.SpringBootFirst.relationMapping.oneToOne.DepartmentOneToOne;
import com.example.SpringBootFirst.relationMapping.oneToOne.OneToOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private OneToOneService oneToOneService;

    @Autowired
    private OneToManyService oneToManyService;

    @Autowired
    private ManyToOneService manyToOneService;

    @Autowired
    private ManyToManyService manyToManyService;


    //Relation Mapping

    @RequestMapping("api/dept/oneToOne")
    public DepartmentOneToOne saveOnetoOne() {
        return oneToOneService.saveOnetoOne();
    }

    @RequestMapping("api/dept/oneToMany")
    public DepartmentOneToMany saveOneToMany() {
        return oneToManyService.saveOneToMany();
    }


    @RequestMapping("api/dept/manyToOne")
    public DepartmentManyToOne saveManyToOne() {
        return manyToOneService.saveManyToOne();
    }

    @GetMapping("api/dept/manyToMany")
    public DepartmentManyToMany saveManyToMany() {
        return manyToManyService.saveManyToMany();
    }

}
