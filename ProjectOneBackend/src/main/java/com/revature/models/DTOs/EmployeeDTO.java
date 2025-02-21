package com.revature.models.DTOs;

import com.revature.models.Employee;

public class EmployeeDTO {
   private int employeeId;
   private String firstname;
   private String lastname;
    private String username;
    private String title;



    public EmployeeDTO() {
    }



    public EmployeeDTO(int employeeId, String firstname, String lastname, String username, String title) {
        this.employeeId = employeeId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.title = title;
    }

    public EmployeeDTO(Employee employee){
        this.employeeId = employee.getEmployeeid();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.username = employee.getUsername();
        this.title = employee.getTitle();
    }



    public int getEmployeeId() {
        return employeeId;
    }



    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }



    public String getFirstname() {
        return firstname;
    }



    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }



    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    

}
