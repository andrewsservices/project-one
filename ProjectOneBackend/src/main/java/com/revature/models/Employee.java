package com.revature.models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeid;


    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String title;


    public Employee() {
    }


    public Employee(int employeeid, String username, String password, String title) {
        this.employeeid = employeeid;
        this.username = username;
        this.password = password;
        this.title = title;
    }


    public int getEmployeeid() {
        return employeeid;
    }


    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Employee [employeeid=" + employeeid + ", username=" + username + ", password=" + password + ", title="
                + title + "]";
    }






}
