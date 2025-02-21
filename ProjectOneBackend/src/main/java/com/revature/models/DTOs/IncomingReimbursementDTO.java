package com.revature.models.DTOs;

public class IncomingReimbursementDTO {
    private int reimbursementId;
    private String description;
    private double amount;
    private String status;
    private int employeeId;

    public IncomingReimbursementDTO() {
    }

    public IncomingReimbursementDTO(int reimbursementId, String description, double amount, String status, int employeeId) {
        this.reimbursementId = reimbursementId;
        this.description = description;
        this.amount = amount;
        this.status = status;
        this.employeeId = employeeId;
    }

    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "IncomingReimbursementDTO [reimbursementId=" + reimbursementId + ", description=" + description
                + ", amount=" + amount + ", status=" + status + ", employeeId=" + employeeId + "]";
    }


    
}
