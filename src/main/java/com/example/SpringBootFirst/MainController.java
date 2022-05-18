package com.example.SpringBootFirst;

import com.example.SpringBootFirst.employeeJPA.Employee;
import com.example.SpringBootFirst.employeeJPA.EmployeeRepo;
import com.example.SpringBootFirst.employeeJPA.EmployeeService;
import com.example.SpringBootFirst.relationMapping.ManyToMany.DepartmentManyToMany;
import com.example.SpringBootFirst.relationMapping.ManyToMany.ManyToManyService;
import com.example.SpringBootFirst.relationMapping.ManyToOne.DepartmentManyToOne;
import com.example.SpringBootFirst.relationMapping.ManyToOne.ManyToOneService;
import com.example.SpringBootFirst.relationMapping.oneToMany.DepartmentOneToMany;
import com.example.SpringBootFirst.relationMapping.oneToMany.OneToManyService;
import com.example.SpringBootFirst.relationMapping.oneToOne.DepartmentOneToOne;
import com.example.SpringBootFirst.relationMapping.oneToOne.OneToOneService;
import com.example.SpringBootFirst.studentHibernate.Student;
import com.example.SpringBootFirst.studentHibernate.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToOne;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OneToOneService oneToOneService;

    @Autowired
    private OneToManyService oneToManyService;

    @Autowired
    private ManyToOneService manyToOneService;

    @Autowired
    private ManyToManyService manyToManyService;



    @RequestMapping("/api/emp/show")
    public List<Employee> show() {
        return employeeService.showEmp();
    }


    @GetMapping("api/emp/findById/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") int id) {

        Employee emp = employeeService.getById(id);
        return ResponseEntity.ok(emp);
    }

    @GetMapping("api/emp/save")
    public Employee saveEmp() {

        return employeeService.saveEmp();
    }


    @GetMapping("api/emp/update")
    public int updateByName() {

        return employeeService.updateByName();
    }


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
        List<Student> students = studentService.showStu();
        return ResponseEntity.ok(students);
    }


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
    public DepartmentManyToMany saveManyToMany(){
        return manyToManyService.saveManyToMany();
    }
}
