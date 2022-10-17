package com.example.SpringBootFirst.activity;

import com.example.SpringBootFirst.HQLpractical.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("api/acti/getall")
    public List getAll() {
        return activityService.getAll();
    }


    @GetMapping("api/acti/saveData")
    public Teacher saveData() {
        return activityService.saveData();
    }


    @GetMapping("/api/acti/updateByDeptName/{tid}/{deptname}")
    public ResponseEntity UpdateTeacherDept(@PathVariable("tid") int tid, @PathVariable("deptname") String depname) {
        return ResponseEntity.ok(activityService.UpdateTeacherDept(tid, depname));
    }

    //or using Query annotation

    @GetMapping("/api/acti/updateTechDepByName/{tid}/{deptname}")
    public ResponseEntity updateTechDepByName(@PathVariable("tid") int tid, @PathVariable("deptname") String depname) {
        return ResponseEntity.ok(activityService.updateTechDepByName(tid, depname));
    }


    @GetMapping("/api/acti/readUncommittedAndReapetableRead")
    public void readUncommittedAndReapetableRead() {
        activityService.readUncommittedAndReapetableRead();
    }

    @GetMapping("/api/acti/executeTran")
    public List<User> executeTran() {
        return activityService.executeTran();
    }


    @GetMapping("/api/acti/readUncommittedLOCKProblem")
    public void readUncommittedLOCKProblem() {
        activityService.readUncommittedLOCKProblem();
    }


}
