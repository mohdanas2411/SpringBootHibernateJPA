package com.example.SpringBootFirst.employeeJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer >{
 //   @Modifying
    @Modifying
    @Query(value = "update employee set name = :ename where id  = 231", nativeQuery = true)
    public void updateEmp(@Param("ename") String ename);
}
