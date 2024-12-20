package com.reimbursementsystem.employeereimbursementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.entity.Reimbursement;
import com.reimbursementsystem.employeereimbursementsystem.service.AccountService;
import com.reimbursementsystem.employeereimbursementsystem.service.ReimbursementService;

@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController{
    @Autowired
    ReimbursementService reimbursementService;

    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Reimbursement> createReimbursement(@RequestBody Reimbursement reimbursement) {
        System.out.println(reimbursement);
        Reimbursement createdReimbursement = this.reimbursementService.createReimbursement(reimbursement);
        if(createdReimbursement == null){
            System.out.println("ITS A NULL\n");
            return ResponseEntity.status(409).body(createdReimbursement);
        }
        return ResponseEntity.status(200).body(createdReimbursement);
    }

    @PatchMapping("/reimbList/{id}")
    public ResponseEntity updateReimbursement(@PathVariable int id,@RequestBody Reimbursement newStatus){
        Reimbursement pulledReimbursement = this.reimbursementService.getReimbursementByReimbId(id);
        if(pulledReimbursement == null){
            System.out.println("ITS A NULL\n");
            return ResponseEntity.status(409).body(pulledReimbursement);
        }
        pulledReimbursement = this.reimbursementService.updateReimbursement(pulledReimbursement,newStatus.getStatus());
        return ResponseEntity.status(200).body(pulledReimbursement);
    }
    @GetMapping("/reimbList/{id}")
    public ResponseEntity deleteReimbursement(@PathVariable int id) {
        Account pulledAccount = this.accountService.getAccountById(id);
        if(pulledAccount==null){
            return ResponseEntity.status(409).body(id); 
        }
        List<Reimbursement> reimbursements = this.reimbursementService.getAllReimbursementsByAccountId(pulledAccount);
        if(reimbursements.isEmpty()){
            return ResponseEntity.status(409).body(reimbursements); 
        }
        return ResponseEntity.status(200).body(reimbursements);
    }   

    
}