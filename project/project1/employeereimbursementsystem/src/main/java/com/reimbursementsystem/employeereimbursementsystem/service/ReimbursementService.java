package com.reimbursementsystem.employeereimbursementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.entity.Reimbursement;
import com.reimbursementsystem.employeereimbursementsystem.repository.ReimbursementRepository;
@Service
public class ReimbursementService {
    @Autowired
    ReimbursementRepository reimbursementRepository;

    @Autowired
    RoleService roleService;
    
    @Autowired 
    AccountService accountService;

    
    public boolean checkId(Reimbursement reimbursement){
        Account account = reimbursement.getAccount();
        Boolean isAccountReal = this.accountService.isIn(account.getAccountId());
        if(!isAccountReal){
            return false;
        }
        return true;
    }
    public Reimbursement getReimbursementByReimbId(int id){
        System.out.println(this.reimbursementRepository.findByReimbId(id));
        return this.reimbursementRepository.findByReimbId(id);
    }
    public Reimbursement createReimbursement(Reimbursement reimbursement){
        if(!checkId(reimbursement)){
            return null;
        }
        Reimbursement pulledReimbursement = this.getReimbursementByReimbId(reimbursement.getReimbId());
        if(pulledReimbursement!=null){
            return null;
        }
        
        Account account = reimbursement.getAccount();
        Account pulledAccount = this.accountService.getAccountById(account.getAccountId());
        reimbursement.setAccount(pulledAccount);
        System.out.println("REMIBURSEMENT"+reimbursement);
        return this.reimbursementRepository.save(reimbursement);
    }
    @Transactional
    public Reimbursement updateReimbursement(Reimbursement reimbursement,String newStatus){
        if(!checkId(reimbursement)){
            return null;
        }
        Reimbursement pulledReimbursement = this.reimbursementRepository.findByReimbId(reimbursement.getReimbId());
        pulledReimbursement.setStatus(newStatus);
        return pulledReimbursement;
    }

    public List<Reimbursement> getAllReimbursementsByAccountId(Account account){
        List<Reimbursement> reimbursements = this.reimbursementRepository.findAllByAccount(account);
        return reimbursements;
    }

    public Reimbursement deleteReimbursement(int reimbId){
        Reimbursement pulledReimbursement = this.reimbursementRepository.findByReimbId(reimbId);
        if(pulledReimbursement==null){
            return null;
        }
        this.reimbursementRepository.delete(pulledReimbursement);
        return pulledReimbursement;
    }

}
