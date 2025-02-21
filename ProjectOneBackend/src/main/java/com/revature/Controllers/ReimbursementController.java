package com.revature.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/reimb")
@CrossOrigin
public class ReimbursementController {
    private final ReimbursementService reimbursementService;

    @Autowired
    public ReimbursementController(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    @PostMapping("/post")
    public ResponseEntity <Reimbursement> postReimbursement(@RequestBody Reimbursement reimbursement){
        Reimbursement returnedReimbursement = reimbursementService.postReimbursement(reimbursement);
        return ResponseEntity.ok(returnedReimbursement);
    }

    @GetMapping
    public ResponseEntity <List<Reimbursement>> getAllReimbursements(){
        return ResponseEntity.ok(reimbursementService.getAllReimbursements());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Reimbursement> findReimbursementById(@RequestParam int id){
        return ResponseEntity.ok(reimbursementService.findReimbursementById(id));
    }
}
