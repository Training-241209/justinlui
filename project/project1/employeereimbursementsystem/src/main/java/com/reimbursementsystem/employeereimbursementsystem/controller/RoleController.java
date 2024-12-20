package com.reimbursementsystem.employeereimbursementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.entity.Role;
import com.reimbursementsystem.employeereimbursementsystem.service.AccountService;
import com.reimbursementsystem.employeereimbursementsystem.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    AccountService accountService;
    @PatchMapping("/updateRole/{username}")
    public ResponseEntity updateRole(@PathVariable String username,@RequestBody String newRole){
        Account pulledAcount = this.accountService.getAccountByUsername(username);
        if(pulledAcount ==null){
            return ResponseEntity.status(409).body(pulledAcount);
        }
        Role role = this.roleService.updateRole(pulledAcount.getRole(), newRole);
        if(role ==null){
            return ResponseEntity.status(409).body(pulledAcount);
        }
        return ResponseEntity.status(200).body(pulledAcount);
    }
}
