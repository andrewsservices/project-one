package com.revature.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Employee;
import com.revature.models.DTOs.OutgoingEmployeeDTO;
import com.revature.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<OutgoingEmployeeDTO> registerEmployee(@RequestBody Employee employee){

        OutgoingEmployeeDTO returnedEmployee = authService.registerEmployee(employee);

        return ResponseEntity.ok(returnedEmployee);
    }

}
