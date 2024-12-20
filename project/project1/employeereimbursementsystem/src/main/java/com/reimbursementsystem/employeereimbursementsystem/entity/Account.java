package com.reimbursementsystem.employeereimbursementsystem.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "accounts")
public class Account {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private Integer accountId;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleIdfk")
    private Role role;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private List<Reimbursement> reimbursement;

    public Account(){
        this.accountId = 0;
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.role = new Role();
        this.reimbursement = new ArrayList<Reimbursement>();
    }
    public Account(int id){
        this.accountId = id;
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.role = new Role();
        this.reimbursement = new ArrayList<Reimbursement>();
    }
    public Account(String firstName, String lastName,String username,String password,Role role ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.reimbursement = new ArrayList<Reimbursement>();
    }
    public int getAccountId(){
        return accountId;
    }
    public void setAccountId(Integer newAccountId){
        this.accountId = newAccountId;
    }

    public String getfirstName(){
        return firstName;
    }
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    public String getUserName(){
        return username;
    }
    public void setUsername(String newUsername){
        this.username = newUsername;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public Role getRole(){
        return role;
    }
    public void setRole(Role newRole){
        this.role = newRole;
    }
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
        
		return true;
	}
    @Override
    public String toString() {
        return "Account{" +
                "userId =" + accountId +
                ", first name = '" + firstName + '\'' +
                ", last name = '" + lastName + '\'' +
                ", username = '" + username + '\'' +
                ", password = '" + password + '\'' +
                ", role = '" + role + '\'' +
                '}';
    }
}

