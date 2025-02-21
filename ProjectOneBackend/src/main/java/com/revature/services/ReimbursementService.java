package com.revature.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAOs.EmployeeDAO;
import com.revature.DAOs.ReimbursementDAO;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.DTOs.IncomingReimbursementDTO;

@Service
public class ReimbursementService {

    @Autowired
    private final ReimbursementDAO reimbursementDAO;
    private final EmployeeDAO employeeDAO;

    @Autowired
    public ReimbursementService(EmployeeDAO employeeDAO, ReimbursementDAO reimbursementDAO) {
        this.employeeDAO = employeeDAO;
        this.reimbursementDAO = reimbursementDAO;
    }


    public Reimbursement postReimbursement(IncomingReimbursementDTO incomingReimbursementDTO){


        Reimbursement newReimbursement = new Reimbursement(
            0,
            incomingReimbursementDTO.getDescription(),
            incomingReimbursementDTO.getAmount(),
            incomingReimbursementDTO.getStatus(),
            null
        );

        Optional<Employee> employee = employeeDAO.findById(incomingReimbursementDTO.getEmployeeId());

        if(employee.isEmpty()){

        } else {
            newReimbursement.setEmployee(employee.get());
        }

        return reimbursementDAO.save(newReimbursement);

    }

    public List<Reimbursement> getAllReimbursements(){
        return reimbursementDAO.findAll();
    }

    public Reimbursement findReimbursementById(int id){
        Optional<Reimbursement> optionalReimbursement = reimbursementDAO.findById(id);
        return optionalReimbursement.orElse(null);
    }

}
