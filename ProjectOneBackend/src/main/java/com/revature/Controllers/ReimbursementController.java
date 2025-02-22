package com.revature.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.aspects.AdminOnly;
import com.revature.models.Reimbursement;
import com.revature.models.DTOs.IncomingReimbursementDTO;
import com.revature.models.DTOs.OutgoingReimbursementDTO;
import com.revature.services.ReimbursementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/reimb")
@CrossOrigin
public class ReimbursementController {
    private final ReimbursementService reimbursementService;

    @Autowired
    public ReimbursementController(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    @PostMapping
    public ResponseEntity<Reimbursement> postReimbursement(@RequestBody IncomingReimbursementDTO reimbursementDTO){

        //send the DTO to the service and return the VideoGame object that comes back
        return ResponseEntity.accepted().body(reimbursementService.postReimbursement(reimbursementDTO));

    }

    @GetMapping
    @AdminOnly
    public ResponseEntity <List<OutgoingReimbursementDTO>> getAllReimbursements(){
        return ResponseEntity.ok(reimbursementService.getAllReimbursements());
    }

    @GetMapping("/employee/{id}")
    @AdminOnly
    public ResponseEntity <List<OutgoingReimbursementDTO>> getReimbursementsByEmployee(@PathVariable int id){
        List<OutgoingReimbursementDTO> reimbursementsByEmployee = reimbursementService.getReimbursementsByEmployee(id);

        return ResponseEntity.ok(reimbursementsByEmployee);
    }


}
