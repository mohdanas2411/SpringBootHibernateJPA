package com.example.SpringBootFirst.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends JpaRepository<Teacher,Integer> {
    @Modifying
    @Query(value = "update teacher set teacher_salary = :tsal, department_dept_id = :depId where teacher_id = :tid",nativeQuery = true)
    public int updateByDeptName(@Param("tsal") Double tsal, @Param("depId") int deptid, @Param("tid") int tid);




//    @Query(value = "SELECT u FROM Department u where ")
//    List<Department> findAllUsers();

}
