package com.revature.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAOs.EmployeeDAO;
import com.revature.DAOs.ReimbursementDAO;
import com.revature.models.Employee;
import com.revature.models.DTOs.OutgoingEmployeeDTO;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;
    private final ReimbursementDAO reimbursementDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO, ReimbursementDAO reimbursementDAO) {
        this.employeeDAO = employeeDAO;
        this.reimbursementDAO = reimbursementDAO;
    }


    public List<OutgoingEmployeeDTO> getAllEmployees(){

        List<Employee> allEmployees = employeeDAO.findAll();

        List<OutgoingEmployeeDTO> employeeDTOs = new ArrayList<>();

        for(Employee e: allEmployees){
            employeeDTOs.add(new OutgoingEmployeeDTO(e));
        }

        return employeeDTOs;
    }

    @Transactional
    public void removeEmployee(int employeeid){
         // Delete all reimbursements associated with the employee
         reimbursementDAO.deleteByEmployee_Employeeid(employeeid);
         // Delete the employee
         employeeDAO.deleteById(employeeid);
    }


}
