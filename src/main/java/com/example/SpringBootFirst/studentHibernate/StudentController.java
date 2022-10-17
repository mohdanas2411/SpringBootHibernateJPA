package com.example.SpringBootFirst.studentHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //through hibernate session factory and session maethods
    @GetMapping("api/stu/get/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        studentService.show();
        return studentService.getStuent(id);
    }

    @RequestMapping("api/stu/save")
    public ResponseEntity saveStu() {
        return ResponseEntity.ok(studentService.saveStu());
    }


    @GetMapping("api/stu/show")
    public ResponseEntity showStudents() {
        List<Student> students = studentService.show();
        return ResponseEntity.ok(students);
    }

    @GetMapping("api/stu/showstu")
    public ResponseEntity showStudentsstu() {
        List<Student> students = studentService.showStu();
        return ResponseEntity.ok(students);
    }
}
