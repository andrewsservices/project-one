package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAOs.EmployeeDAO;
import com.revature.models.Employee;

@Service
public class AuthService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public AuthService(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    public Employee registerEmployee(Employee employee){


        return employeeDAO.save(employee);

    }
}
