package com.greychaindesign.loan_management.exception;

import com.greychaindesign.loan_management.model.Loan;

import java.util.function.Supplier;

public class InvalidLoanException extends RuntimeException {
    public InvalidLoanException(String message) {
        super(message);
    }
}
