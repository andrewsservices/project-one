package com.revature.DAOs;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Reimbursement;

@Repository
public interface ReimbursementDAO extends JpaRepository<Reimbursement, Integer> {
   public List<Reimbursement> findByEmployee_Employeeid(int employeeid);
   void deleteByEmployee_Employeeid(int employeeid);
}
