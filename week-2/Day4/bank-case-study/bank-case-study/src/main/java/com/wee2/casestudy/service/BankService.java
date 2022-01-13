package com.wee2.casestudy.service;

import com.wee2.casestudy.domain.BankAccount;
import com.wee2.casestudy.exception.InvalidAmountException;

import java.util.List;

public interface BankService {

    int createNewAccount(BankAccount ba);

    int updateAccountDetails(BankAccount ba);

    boolean activateAccount(Long acNum);

    boolean deActivateAccount(Long acNum);

    double withdraw(Long acNum, double amt) throws InvalidAmountException;

    double deposit(Long acNum, int amt) throws InvalidAmountException;

    int transferMoney(Long srcAc, Long dstAc, int amt) throws InvalidAmountException;

    BankAccount findAccountByAcNum(Long acNum);

    List<BankAccount> findAllBankAccounts();

    List<BankAccount> namesStartsWith(String prefix);
}
