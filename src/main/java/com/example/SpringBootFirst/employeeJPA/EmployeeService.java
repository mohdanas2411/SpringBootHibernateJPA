package com.example.SpringBootFirst.employeeJPA;

import com.example.SpringBootFirst.CustomResourceNotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;


    public List<Employee> showEmp() {
        return employeeRepo.findAll();
    }

    public Employee getById(int id) {
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new CustomResourceNotFoundException("Not found employee with id : " + id));
        return emp;
    }

    public Employee saveEmp(Employee emp) {
//        Employee emp = new Employee();
//        emp.setAddress("Okhla");
//        emp.setName("ABC");
//        emp.setFullname(emp.getFullname() + emp.getName());
        return employeeRepo.save(emp);
    }

    @Autowired
    Session session;

    @Transactional(rollbackFor = IOException.class, timeoutString = "5")
    public String updateByName() throws IOException {

        employeeRepo.updateEmp("why gaal");

        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            return  "calm boi data updated";
        }

//        FileReader file = new FileReader("C:\\test\\a.txt");
//
//        // Reading content inside a file
//        BufferedReader fileInput = new BufferedReader(file);
//
//        // Printing first 3 lines of file "C:\test\a.txt"
//        for (int counter = 0; counter < 3; counter++)
//            System.out.println(fileInput.readLine());
//
//        // Closing all file connections
//        // using close() method
//        // Good practice to avoid any memory leakage
//        fileInput.close();
//        try {
//            int c = 10 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println("exception e");
//            throw new ArithmeticException();
//            // it will not rollback as it think we handled this exception in our finally block;
//        }
//        finally {
//            return "hello";
//        }
//
    }

    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }

    public void updateById(Employee employee) {
        employeeRepo.save(employee);
    }
}
