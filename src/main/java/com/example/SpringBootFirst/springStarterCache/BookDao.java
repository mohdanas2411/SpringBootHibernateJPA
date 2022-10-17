package com.example.SpringBootFirst.springStarterCache;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Books,Integer> {
}
