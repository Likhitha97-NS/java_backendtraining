package com.week2bankapp.restbankapp.service;


import com.week2bankapp.restbankapp.domain.BankAccount;
import com.week2bankapp.restbankapp.dto.AppResponse;
import com.week2bankapp.restbankapp.exception.InvalidAmountException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BankService {

    int createNewAccount(BankAccount ba);

    int updateAccountDetails(BankAccount ba);

    ResponseEntity<AppResponse<Integer>> updateAccountDetails();

    boolean activateAccount(Long acNum);

    boolean deActivateAccount(Long acNum);

    double withdraw(Long acNum, double amt) throws InvalidAmountException;

    double deposit(Long acNum, int amt) throws InvalidAmountException;

    int transferMoney(Long srcAc, Long dstAc, int amt) throws InvalidAmountException;

    BankAccount findAccountByAcNum(Long acNum);

    List<BankAccount> findAllBankAccounts();

    List<BankAccount> namesStartsWith(String prefix);

}
