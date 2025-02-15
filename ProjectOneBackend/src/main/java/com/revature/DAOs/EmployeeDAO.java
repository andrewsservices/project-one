package com.revature.DAOs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

}
