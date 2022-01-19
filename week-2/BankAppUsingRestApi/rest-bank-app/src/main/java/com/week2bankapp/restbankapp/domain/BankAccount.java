package com.week2bankapp.restbankapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int acNum;
    private String acHldNm;
    private double balance;
    private Date AcCrDt;
    private boolean status;

    public BankAccount() {
    }

    public BankAccount(int acNum, String acHldNm, double balance, Date acCrDt, boolean status) {
        this.acNum = acNum;
        this.acHldNm = acHldNm;
        this.balance = balance;
        AcCrDt = acCrDt;
        this.status = status;
    }

    public int getAcNum() {
        return acNum;
    }

    public void setAcNum(int acNum) {
        this.acNum = acNum;
    }

    public String getAcHldNm() {
        return acHldNm;
    }

    public void setAcHldNm(String acHldNm) {
        this.acHldNm = acHldNm;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getAcCrDt() {
        return AcCrDt;
    }

    public void setAcCrDt(Date acCrDt) {
        AcCrDt = acCrDt;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
