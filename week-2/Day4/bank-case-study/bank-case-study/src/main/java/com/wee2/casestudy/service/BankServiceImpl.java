package com.wee2.casestudy.service;

import com.wee2.casestudy.domain.BankAccount;
import com.wee2.casestudy.exception.InvalidAmountException;
import com.wee2.casestudy.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Transactional(isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidAmountException.class)

@Service
public class BankServiceImpl implements BankService {

    private final Logger logger= LoggerFactory.getLogger(BankServiceImpl.class);
    @Autowired
    private BankRepository repository;

    @Override
    public int createNewAccount(BankAccount ba) {
        return 0;
    }

    @Override
    public int updateAccountDetails(BankAccount ba) {
        return 0;
    }

    @Override
    public boolean activateAccount(Long acNum) {
        return false;
    }

    @Override
    public boolean deActivateAccount(Long acNum) {
        return false;
    }

    @Override
    public double withdraw(Long acNum, double amt) throws InvalidAmountException {
        logger.info("withdrawing money from "+acNum+"with amount"+amt);
        logger.warn("Make sure amount is positive");
        repository.withdraw(amt, acNum);
        return amt;
    }

    @Override
    public double deposit(Long acNum, int amt) throws InvalidAmountException{
        if(amt<=0)throw new InvalidAmountException("amount should be non zero positive "+amt);
        Optional<BankAccount> op=repository.findById(acNum);
        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance + amt;

        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());
        repository.save(baNew);
        //        withdraw(acNum, 10);
        return baNew.getBalance();
    }

    @Override
    public int transferMoney(Long srcAc, Long dstAc, int amt) {
        return 0;
    }

    @Override
    public BankAccount findAccountByAcNum(Long acNum) {
        return null;
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        return null;
    }

    @Override
    public List<BankAccount> namesStartsWith(String prefix) {
        return repository.findByAcHldNmStartingWith(prefix);
    }
}
