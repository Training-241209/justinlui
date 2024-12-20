package com.reimbursementsystem.employeereimbursementsystem.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "reimbursements")
public class Reimbursement {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reimbId")
    private Integer reimbId;

    @Column(name = "description")
    private String descript;
    @Column(name = "amount")
    private float amount;
    @Column(name = "status")
    private String statusName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "accountIdfk", referencedColumnName = "accountId")
    private Account account;

    public Reimbursement(){
        this.reimbId = 0;
        this.statusName = "";
        this.amount = 0;
        this.account = new Account();
    }
    public Reimbursement(String status){
        this.reimbId = 0;
        this.statusName = status;
        this.amount = 0;
        this.account = new Account();
    }

    public Reimbursement(String description, float amount,String status, Account account){
        this.descript = description;
        this.amount = amount;
        this.statusName = status;
        this.account = account;
    }

    public Integer getReimbId(){
        return reimbId;
    }
    public void setReimbId(Integer newReimbId){
        reimbId = newReimbId;
    }

    public String getDescription(){
        return descript;
    }
    public void setDescription(String newDescription){
        descript = newDescription;
    }

    public float getAmount(){
        return amount;
    }
    public void setAmount(float newAmount){
        amount = newAmount;
    }

    public String getStatus(){
        return statusName;
    }
    public void setStatus(String newStatus){
        statusName = newStatus;
    }

    public Account getAccount(){
        return account;
    }
    public void setAccount(Account newAccount){
        account = newAccount;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
        if (reimbId == null) {
			if (other.reimbId != null)
				return false;
		} else if (!reimbId.equals(other.reimbId))
			return false;
        if (descript == null) {
			if (other.descript != null)
				return false;
		} else if (!descript.equals(other.descript))
			return false;
        if (amount == 0.0f) {
			if (other.amount != 0.0f)
				return false;
		} else if (amount!=(other.amount))
			return false; 
        if (statusName == null) {
			if (other.statusName != null)
				return false;
		} else if (!statusName.equals(other.statusName))
			return false;
        
        return true;
    }
    @Override
    public String toString() {
        return "Reimbursement{" +
                " Reimbursement ID = '" + reimbId + '\'' +
                ", Description = '" + descript + '\'' +
                ", Amount = '" + amount + '\'' +
                ", Status = '" + statusName + '\'' +
                ", Account ID = '" + account.getAccountId() + '\'' +
                '}';
    }
}
