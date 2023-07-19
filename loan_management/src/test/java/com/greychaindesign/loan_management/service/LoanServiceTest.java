package com.greychaindesign.loan_management.service;

import com.greychaindesign.loan_management.dto.LoanDto;
import com.greychaindesign.loan_management.exception.InvalidLoanException;
import com.greychaindesign.loan_management.model.Loan;
import com.greychaindesign.loan_management.repo.LoanRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanService loanService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAggregateRemainingAmountByLender() {
        when(loanRepository.sumRemainingAmountByLender(any())).thenReturn(25000.0);
        double result = loanService.aggregateRemainingAmountByLender("LEN1");
        Assertions.assertEquals(25000.0, result);
    }

    @Test
    void testAggregateInterestByLender() {
        when(loanRepository.sumInterestByLender(any())).thenReturn(0.02);
        double result = loanService.aggregateInterestByLender("LEN1");
        Assertions.assertEquals(0.02, result);
    }

    @Test
    void testAggregatePenaltyByLender() {
        when(loanRepository.sumPenaltyByLender(any())).thenReturn(0.01);
        double result = loanService.aggregatePenaltyByLender("LEN1");
        Assertions.assertEquals(0.01, result);
    }


    @Test
    void testAggregateRemainingAmountByCustomerId() {
        when(loanRepository.sumRemainingAmountByCustomerId(any())).thenReturn(30000.0);
        double result = loanService.aggregateRemainingAmountByCustomerId("C1");
        Assertions.assertEquals(30000.0, result);
    }

    @Test
    void testAggregateInterestByCustomerId() {
        when(loanRepository.sumInterestByCustomerId(any())).thenReturn(0.03);
        double result = loanService.aggregateInterestByCustomerId("C1");
        Assertions.assertEquals(0.03, result);
    }

    @Test
    void testAggregatePenaltyByCustomerId() {
        when(loanRepository.sumPenaltyByCustomerId(any())).thenReturn(0.015);
        double result = loanService.aggregatePenaltyByCustomerId("C1");
        Assertions.assertEquals(0.015, result);
    }

    // Helper method to create a sample Loan object
    private Loan createSampleLoan(String loanId, String customerId, String lenderId,
                                  double amount, double remainingAmount, String paymentDate,
                                  int interestPerDay, String dueDate, double dueDatePenalty) {
        Loan loan = new Loan();
        loan.setCustomerId(customerId);
        loan.setLenderId(lenderId);
        loan.setAmount(amount);
        loan.setRemainingAmount(remainingAmount);
        loan.setPaymentDate(paymentDate);
        loan.setInterestPerDay(interestPerDay);
        loan.setDueDate(dueDate);
        loan.setDueDatePenalty(dueDatePenalty);
        return loan;
    }
}