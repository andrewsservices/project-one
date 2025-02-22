package com.revature.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAOs.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.models.DTOs.OutgoingEmployeeDTO;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    public List<OutgoingEmployeeDTO> getAllEmployees(){

        List<Employee> allEmployees = employeeDAO.findAll();

        List<OutgoingEmployeeDTO> employeeDTOs = new ArrayList<>();

        for(Employee e: allEmployees){
            employeeDTOs.add(new OutgoingEmployeeDTO(e));
        }

        return employeeDTOs;
    }
}
