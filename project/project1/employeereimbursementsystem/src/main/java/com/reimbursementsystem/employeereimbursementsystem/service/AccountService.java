package com.reimbursementsystem.employeereimbursementsystem.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.entity.Role;
import com.reimbursementsystem.employeereimbursementsystem.repository.AccountRepository;
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleService roleService;

    public Boolean isIn(int accountId){
        Account account = getAccountById(accountId);
        if(account==null){
            return false;
        }
        return true;
    }
    public Account getAccountById(int accountId){
        return this.accountRepository.findByAccountId(accountId);
    }
    public Account getAccountByUsername(String username){
        return this.accountRepository.findByUsername(username);
    }

    public Account createAccount(Account account){
        Role createdRole = this.roleService.createRole(account.getRole().getRoleName());
        account.setRole(createdRole);
        Account exisitingAccount = this.getAccountByUsername(account.getUserName());
        if(exisitingAccount!= null){
           return null;
        }
        String hashed = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());
        account.setPassword(hashed);
        return this.accountRepository.save(account);
    }
    @Transactional
    public Account deleteAccount(String username){
        Account account = this.getAccountByUsername(username);
        if(account == null){
            return null;
        }
        Account pulledAccount = account;
        this.accountRepository.deleteById(account.getAccountId());
        return pulledAccount;
    }
}
