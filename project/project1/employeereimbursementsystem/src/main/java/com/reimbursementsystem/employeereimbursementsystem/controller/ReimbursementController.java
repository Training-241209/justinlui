package com.reimbursementsystem.employeereimbursementsystem.controller;

import com.reimbursementsystem.employeereimbursementsystem.entity.Reimbursement;
import com.reimbursementsystem.employeereimbursementsystem.service.ReimbursementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController{
    @Autowired
    ReimbursementService reimbursementService;

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
    
}