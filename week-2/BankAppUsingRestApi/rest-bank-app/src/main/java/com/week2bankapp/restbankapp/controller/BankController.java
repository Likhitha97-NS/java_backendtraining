package com.week2bankapp.restbankapp.controller;

import com.week2bankapp.restbankapp.domain.BankAccount;
import com.week2bankapp.restbankapp.dto.AppResponse;
import com.week2bankapp.restbankapp.exception.InvalidAmountException;
import com.week2bankapp.restbankapp.service.BankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/bank")
@RestController
public class BankController {

    private final Logger logger = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private BankService service;

    @PostMapping // POST -> http://localhost:8080/bank/
    public ResponseEntity<AppResponse<Integer>> createBankAccount(@RequestBody BankAccount ba) {

        logger.info("creating bank account");

        service.createNewAccount(ba);

        var response = new AppResponse<Integer>();
        response.setMsg("account created successfully");
        response.setSts("success");
        response.setBody(0);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/withdraw") // PUT -> http://localhost:8080/bank/withdraw
    public ResponseEntity<AppResponse<Double>> withdrawMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.withdraw((long) ba.getAcNum(), ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("Withdrawn Successfully");
            response.setSts("Success");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/deposit") // PUT -> http://localhost:8080/bank/deposit
    public ResponseEntity<AppResponse<Double>> depositMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.deposit((long) ba.getAcNum(), (int) ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("Deposit Successfully");
            response.setSts("Success");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{prefix}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(service.namesStartsWith(prefix));

        return ResponseEntity.ok(response);
    }


    @PutMapping("/deActivate")
    public ResponseEntity<AppResponse<Boolean>> Deactivate(@RequestBody BankAccount ba) {
        boolean stat = service.deActivateAccount((long) ba.getAcNum());
        var response = new AppResponse<Boolean>();
        response.setMsg("Account DeActivated");
        response.setSts("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


    @PutMapping("/activate")
    public ResponseEntity<AppResponse<Boolean>> activate(@RequestBody BankAccount ba) {
        boolean stat = service.activateAccount((long) ba.getAcNum());
        var response = new AppResponse<Boolean>();
        response.setMsg("Account Activated");
        response.setSts("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


    @GetMapping("/finaall")
    public List<BankAccount> findAll() {
        return service.findAllBankAccounts();
    }

    @PutMapping("/transfer") // PUT -> http://localhost:8080/bank/transfer
    public ResponseEntity<AppResponse<Double>> transferMoney(@RequestBody BankAccount ba) {
        try {
            double amt = service.transferMoney((long) ba.getAcNum(), (long) ba.getAcNum(), (int) ba.getBalance());
            var response = new AppResponse<Double>();
            response.setMsg("Transfer Successfully");
            response.setSts("Success");
            response.setBody(amt);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (InvalidAmountException e) {
            var response = new AppResponse<Double>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(0.0);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/num/{acNum}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStart(@PathVariable Long acNum) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody((List<BankAccount>) service.findAccountByAcNum(acNum));
        return ResponseEntity.ok(response);
    }



}
