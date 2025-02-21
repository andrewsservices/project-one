package com.revature.DAOs;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Reimbursement;

@Repository
public interface ReimbursementDAO extends JpaRepository<Reimbursement,Integer>{

    public Optional<Reimbursement> findById(Integer id);

}
