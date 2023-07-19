package com.greychaindesign.loan_management.controller;

import com.greychaindesign.loan_management.dto.LoanDto;
import com.greychaindesign.loan_management.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/")
    public ResponseEntity<?> addLoan(@RequestBody LoanDto loan) {
        return new ResponseEntity<>(loanService.saveLoan(loan), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        List<LoanDto> loans = loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> getById(@PathVariable("id") Long id) {
        LoanDto loan = loanService.getById(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LoanDto> deleteById(@PathVariable("id") Long id) {
        LoanDto loan = loanService.deleteById(id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @GetMapping("/lender/amount/{id}")
    public ResponseEntity<?> aggregateRemainingAmountByLender(@PathVariable("id") Long id) {
        return new ResponseEntity<>(loanService
                .aggregateRemainingAmountByLender(String.valueOf(id)), HttpStatus.OK);
    }

    @GetMapping("/lender/interest/{id}")
    public ResponseEntity<?> aggregateInterestByLender(@PathVariable("id") Long id) {
        return new ResponseEntity<>(loanService
                .aggregateInterestByLender(String.valueOf(id)), HttpStatus.OK);
    }

    @GetMapping("/lender/penalty/{id}")
    public ResponseEntity<?> aggregatePenaltyByLender(@PathVariable("id") Long id) {
        return new ResponseEntity<>(loanService
                .aggregatePenaltyByLender(String.valueOf(id)), HttpStatus.OK);
    }

    @GetMapping("/interest/amount/{interestPerDay}")
    public ResponseEntity<?> aggregateRemainingAmountByInterest(@PathVariable("interestPerDay") int interestPerDay) {
        return new ResponseEntity<>(loanService
                .aggregateRemainingAmountByInterest(interestPerDay), HttpStatus.OK);
    }

    @GetMapping("/interest/{interestPerDay}")
    public ResponseEntity<?> aggregateInterestByInterest(@PathVariable("interestPerDay") int interestPerDay) {
        return new ResponseEntity<>(loanService
                .aggregateInterestByInterest(interestPerDay), HttpStatus.OK);
    }

    @GetMapping("/interest/penalty/{interestPerDay}")
    public ResponseEntity<?> aggregatePenaltyByInterest(@PathVariable("interestPerDay") int interestPerDay) {
        return new ResponseEntity<>(loanService
                .aggregatePenaltyByInterest(interestPerDay), HttpStatus.OK);
    }

    @GetMapping("/customer/amount/{customerId}")
    public ResponseEntity<?> aggregateRemainingAmountByCustomerId(@PathVariable("customerId") int customerId) {
        return new ResponseEntity<>(loanService
                .aggregateRemainingAmountByCustomerId(String.valueOf(customerId)), HttpStatus.OK);
    }


    @GetMapping("/customer/interest/{customerId}")
    public ResponseEntity<?> aggregateInterestByCustomerId(@PathVariable("customerId") int customerId) {
        return new ResponseEntity<>(loanService
                .aggregateInterestByCustomerId(String.valueOf(customerId)), HttpStatus.OK);
    }

    @GetMapping("/customer/penalty/{customerId}")
    public ResponseEntity<?> aggregatePenaltyByCustomerId(@PathVariable("customerId") int customerId) {
        return new ResponseEntity<>(loanService
                .aggregatePenaltyByCustomerId(String.valueOf(customerId)), HttpStatus.OK);
    }

}