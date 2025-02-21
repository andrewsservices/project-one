package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAOs.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.models.DTOs.EmployeeDTO;

@Service
public class AuthService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public AuthService(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    public EmployeeDTO registerEmployee(Employee employee){

        Employee returnedEmployee = employeeDAO.save(employee);

        EmployeeDTO registeredEmployee = new EmployeeDTO(
            returnedEmployee.getEmployeeid(),
            returnedEmployee.getFirstname(),
            returnedEmployee.getLastname(),
            returnedEmployee.getUsername(),
            returnedEmployee.getTitle()
        );

        return registeredEmployee;

    }
}
