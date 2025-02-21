package com.revature.models.DTOs;

public class IncomingReimbursementDTO {
    private int reimbursementid;
    private String description;
    private double amount;
    private String status;
    private int employeeid;

    public IncomingReimbursementDTO() {
    }

    public IncomingReimbursementDTO(int reimbursementid, String description, double amount, String status, int employeeid) {
        this.reimbursementid = reimbursementid;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.employeeid = employeeid;
    }

    public int getReimbursementid() {
        return reimbursementid;
    }

    public void setReimbursementid(int reimbursementid) {
        this.reimbursementid = reimbursementid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public String toString() {
        return "IncomingReimbursementDTO [reimbursementid=" + reimbursementid + ", description=" + description
                + ", amount=" + amount + ", status=" + status + ", employeeid=" + employeeid + "]";
    }



}
