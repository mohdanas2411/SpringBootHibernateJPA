package com.example.SpringBootFirst.employeeJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/api/emp/show")
    public List<Employee> show() {
        return employeeService.showEmp();
    }


    @GetMapping("api/emp/findById/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") int id) {

        Employee emp = employeeService.getById(id);
        return ResponseEntity.ok(emp);
    }

    @PostMapping("api/emp/save")
    public Employee saveEmp(@RequestBody Employee emp) {

        return employeeService.saveEmp(emp);
    }




    @PutMapping ("api/emp/updateByName")
    public String updateByName() throws IOException {

        return employeeService.updateByName();

    }

    @PutMapping ("api/emp/updateById/")
    public void updateById(@RequestBody Employee employee) throws IOException {

         employeeService.updateById(employee);

    }

    @DeleteMapping ("api/emp/delete/{id}")
    public void deleteById(@PathVariable("id") int id) throws IOException {

         employeeService.deleteById(id);

    }
}
