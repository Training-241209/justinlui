package com.reimbursementsystem.employeereimbursementsystem.repository;
import com.reimbursementsystem.employeereimbursementsystem.entity.Reimbursement;
import com.reimbursementsystem.employeereimbursementsystem.entity.Account;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ReimbursementRepository extends JpaRepository<Reimbursement,Long>{
    @Autowired
    public Reimbursement findByReimbId(int reimbId);

    @Transactional
    public void deleteByReimbId(int reimbId);

    public List<Reimbursement> findAllByAccount(Account account);

    public List<Reimbursement> findAll();

    public List<Reimbursement> findAllByStatusName(String reimbStatus);

}
