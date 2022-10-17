package com.example.SpringBootFirst.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {

    @Query(value = "select * from department where dept_name = :deptName",nativeQuery = true)
    public Department getDeptByName(@Param("deptName") String deptName);
}
