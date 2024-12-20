package com.reimbursementsystem.employeereimbursementsystem.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "employeeStatus")
    private String employeeStatus;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "accountId", cascade = CascadeType.ALL)
    private List<Account> accounts;

    public Role(){
        this.id = 0;
        this.employeeStatus = "";
        accounts = new ArrayList<Account>();
    }
    public Role(String roleName){
        this.employeeStatus = roleName;
        this.accounts = new ArrayList<Account>();
    }
    public String getRoleName(){
        return employeeStatus;
    }
    public void setRole(String roleName){
        this.employeeStatus = roleName;
    }
    public Account getRoleByAccount(Account account){
        for(int i = 0; i < this.accounts.size();i++){
            if(accounts.get(i)==account){
                return account;
            }
        }
        return null;
    }
}
