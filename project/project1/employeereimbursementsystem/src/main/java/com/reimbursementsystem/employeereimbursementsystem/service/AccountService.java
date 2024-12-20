package com.reimbursementsystem.employeereimbursementsystem.service;

import com.reimbursementsystem.employeereimbursementsystem.repository.AccountRepository;
import com.reimbursementsystem.employeereimbursementsystem.entity.Account;
import com.reimbursementsystem.employeereimbursementsystem.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.mindrot.jbcrypt.BCrypt;
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
        System.out.println("\nACCOUNT\n"+account+"\n");
        Role createdRole = this.roleService.createRole(account.getRole().getRoleName());
        account.setRole(createdRole);
        Account exisitingAccount = this.getAccountByUsername(account.getUserName());
        System.out.println("\nExisting ACCOUNT\n"+(exisitingAccount!=null)+"\n");
        if(exisitingAccount!= null){
            System.out.println("RETURN NULL");
           return null;
        }
        String hashed = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt());
        account.setPassword(hashed);
        return this.accountRepository.save(account);
    }
    @Transactional
    public Account deleteAccount(Account account){
        this.accountRepository.delete(account);
        return account;
    }
}
