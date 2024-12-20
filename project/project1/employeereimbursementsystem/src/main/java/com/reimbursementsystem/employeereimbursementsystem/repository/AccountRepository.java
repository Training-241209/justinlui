package com.reimbursementsystem.employeereimbursementsystem.repository;
import com.reimbursementsystem.employeereimbursementsystem.entity.Account;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    @Autowired
    public Account findByAccountId(int accountId);
    @Autowired 
    public Account findByUsername(String username);

    @Transactional
    public void deleteByAccountId(int accountId);

    public List<Account> findAll();

}