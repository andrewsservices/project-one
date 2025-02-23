package com.revature.DAOs;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

    public Optional<Employee> findByUsernameAndPassword(String username,String password);

    
}
