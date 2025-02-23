package com.revature.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.aspects.AdminOnly;

import com.revature.models.Employee;
import com.revature.models.DTOs.OutgoingEmployeeDTO;
import com.revature.services.EmployeeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/employees")

@CrossOrigin(value="http://localhost:5173",allowCredentials = "true")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    @AdminOnly
    public ResponseEntity<List<OutgoingEmployeeDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

}
