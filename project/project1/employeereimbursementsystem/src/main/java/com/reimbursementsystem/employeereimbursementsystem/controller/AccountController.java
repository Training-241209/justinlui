package com.reimbursementsystem.employeereimbursementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.service.AccountService;

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
        Account pulledAccount = this.accountService.getAccountByUsername(username);
        if(pulledAccount == null){
            return ResponseEntity.status(409).body(pulledAccount);
        }
        return ResponseEntity.status(200).body(pulledAccount);
    }
    @DeleteMapping("/accounts/{username}")
    public ResponseEntity deleteAccount(@PathVariable String username) {
        Account deletedAccount = this.accountService.deleteAccount(username);
        if(deletedAccount == null){
            return ResponseEntity.status(409).body(username);
        }
        return ResponseEntity.status(200).body(deletedAccount);
    }
}