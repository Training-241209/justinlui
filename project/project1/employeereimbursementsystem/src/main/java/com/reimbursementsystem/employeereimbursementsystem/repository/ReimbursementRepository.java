package com.reimbursementsystem.employeereimbursementsystem.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.entity.Reimbursement;

import jakarta.transaction.Transactional;
@Component
public interface ReimbursementRepository extends JpaRepository<Reimbursement,Integer>{
    @Autowired
    public Reimbursement findByReimbId(int reimbId);

    @Transactional
    public void deleteByReimbId(int reimbId);

    public List<Reimbursement> findAllByAccount(Account accountId);

    public List<Reimbursement> findAll();

    public List<Reimbursement> findAllByStatusName(String reimbStatus);

}
