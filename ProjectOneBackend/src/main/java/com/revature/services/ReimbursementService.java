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
import com.revature.models.DTOs.OutgoingReimbursementDTO;

@Service
public class ReimbursementService {

    @Autowired
    private final ReimbursementDAO reimbursementDAO;
    @Autowired
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

        Optional<Employee> employee = employeeDAO.findById(incomingReimbursementDTO.getEmployeeid());

        if(employee.isEmpty()){
            //TODO: throw an exception
        } else {
            //If the user exists, we can set it in the game object
            newReimbursement.setEmployee(employee.get());
            //get() is how we extract data from an optional
        }

        return reimbursementDAO.save(newReimbursement);

    }

    public List<OutgoingReimbursementDTO> getAllReimbursements(){

        List<OutgoingReimbursementDTO> reimbursementDTOs = new java.util.ArrayList<>();

        List<Reimbursement> reimbursements = reimbursementDAO.findAll();

        for(Reimbursement r: reimbursements){
            OutgoingReimbursementDTO newOutgoingReimbursementDTO = new OutgoingReimbursementDTO(
                r.getReimbursementid(),
                r.getDescription(),
                r.getAmount(),
                r.getStatus(),
                r.getEmployee().getEmployeeid()
            );


            reimbursementDTOs.add(newOutgoingReimbursementDTO);
        }

        return reimbursementDTOs;
    }


    public List<OutgoingReimbursementDTO> getReimbursementsByEmployee(int employeeid){
        List<Reimbursement> reimbursementsById = reimbursementDAO.findByEmployee_Employeeid(employeeid);

        List<OutgoingReimbursementDTO> reimbursementsDTO = new java.util.ArrayList<>();

        for(Reimbursement r: reimbursementsById){
            OutgoingReimbursementDTO newOutgoingReimbursementDTO = new OutgoingReimbursementDTO(
                r.getReimbursementid(),
                r.getDescription(),
                r.getAmount(),
                r.getStatus(),
                r.getEmployee().getEmployeeid()
            );

            reimbursementsDTO.add(newOutgoingReimbursementDTO);
        }


        return reimbursementsDTO;
    }

}
