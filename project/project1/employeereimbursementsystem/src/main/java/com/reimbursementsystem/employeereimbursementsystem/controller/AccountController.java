package com.reimbursementsystem.employeereimbursementsystem.controller;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleController roleController;

    @PostMapping("/register")
    public ResponseEntity createAccount(@RequestBody Account account) {
        Account createdAccount = this.accountService.createAccount(account);
        System.out.println("CREATED ACCOUNT IS " +createdAccount);
        if(createdAccount == null){
            System.out.println("Please return");
            return ResponseEntity.status(409).body(account);
        }
        
        return ResponseEntity.status(200).body(createdAccount);
    }
    @GetMapping("/accounts/{username}")
    public ResponseEntity retrievedAccount(@PathVariable String username) {
        Account pulledAccount = accountService.getAccountByUsername(username);
        if(pulledAccount == null){
            return ResponseEntity.status(409).body(pulledAccount);
        }
        return ResponseEntity.status(200).body(pulledAccount);
    }
    // @DeleteMapping("/accounts/{username}")
    // public ResponseEntity deleteAccount(@PathVariable String username) {
    //     if(deletedAccount == null){
    //         return ResponseEntity.status(409).body(username);
    //     }
    //     return ResponseEntity.status(409).body(deletedAccount);
    // }
}