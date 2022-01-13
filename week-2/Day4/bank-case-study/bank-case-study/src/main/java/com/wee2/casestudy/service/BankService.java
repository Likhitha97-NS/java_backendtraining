package com.wee2.casestudy.service;

import com.wee2.casestudy.domain.BankAccount;

import javax.transaction.Transactional;
import java.util.List;

public interface BankService {

    int createNewAccount(BankAccount ba);

    int updateAccountDetails(BankAccount ba);

    boolean activateAccount(Long acNum);

    boolean deActivateAccount(Long acNum);

    double withdraw(Long acNum, int amt);

    @Transactional
    double withdraw(Long acNum, double amt);

    double deposit(Long acNum, int amt);

    int transferMoney(Long srcAc, Long dstAc, int amt);

    BankAccount findAccountByAcNum(Long acNum);

    List<BankAccount> findAllBankAccounts();

    List<BankAccount> namesStartsWith(String prefix);
}
