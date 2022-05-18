package com.example.SpringBootFirst.employeeJPA;

import com.example.SpringBootFirst.CustomResourceNotFoundException;
import com.example.SpringBootFirst.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;



    public List<Employee> showEmp(){
        return employeeRepo.findAll();
    }
    public Employee getById(int id) {
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("Not found employee with id : " + id));
        return emp;
    }

    public Employee saveEmp(){
        Employee emp = new Employee();
        emp.setAddress("Okhla");
        emp.setName("ABC");
        emp.setFullname(emp.getFullname()+emp.getName());
        return employeeRepo.save(emp);
    }

    public int updateByName(){
        employeeRepo.updateEmp("update it");
        TransactionInterceptor
        return 1;
    }

}
