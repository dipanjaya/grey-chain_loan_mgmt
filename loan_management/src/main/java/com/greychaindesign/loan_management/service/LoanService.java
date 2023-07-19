package com.greychaindesign.loan_management.service;

import com.greychaindesign.loan_management.dto.LoanDto;
import com.greychaindesign.loan_management.exception.InvalidLoanException;
import com.greychaindesign.loan_management.model.Loan;
import com.greychaindesign.loan_management.repo.LoanRepository;
import com.greychaindesign.loan_management.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;


    public LoanDto saveLoan(final LoanDto loanDto) {
//        loanDto.setLoanId(null);

        if (DateUtils.isDateGreaterThan(loanDto.getPaymentDate(), loanDto.getDueDate())) {
            throw new InvalidLoanException("Payment date cannot be greater than the due date.");
        }

        Loan loan = new Loan();
        BeanUtils.copyProperties(loanDto, loan);

        LoanDto dto = new LoanDto(loanRepository.save(loan));

        if (DateUtils.isDateGreaterThan(DateUtils.getCurrentDate(),loanDto.getDueDate())) {
            log.error("Overdue alert : Loan id  - {} : Customer id - {} : Lender id - {} ",dto.getId(),
                    dto.getCustomerId(), dto.getLenderId());
        }

        return dto;
    }

    public List<LoanDto> getAllLoans() {
        return loanRepository.findAll().stream().map(LoanDto::new).collect(Collectors.toList());
    }

    public LoanDto getById(final long loanId) {
        Loan loan = loanRepository.getReferenceById(loanId);
        return new LoanDto(loan);
    }

    public LoanDto deleteById(final long loanId) {

        LoanDto loanDto = getById(loanId);

        Loan loan = new Loan();
        BeanUtils.copyProperties(loanDto, loan);

        loanRepository.deleteById(loanDto.getId());
        loanDto.setId(null);
        return loanDto;
    }

    public double aggregateRemainingAmountByLender(String lenderId) {
        return loanRepository.sumRemainingAmountByLender(lenderId);
    }

    public double aggregateInterestByLender(String lenderId) {
        return loanRepository.sumInterestByLender(lenderId);
    }

    public double aggregatePenaltyByLender(String lenderId) {
        return loanRepository.sumPenaltyByLender(lenderId);
    }

    public double aggregateRemainingAmountByInterest(int interestPerDay) {
        return loanRepository.sumRemainingAmountByInterest(interestPerDay);
    }

    public double aggregateInterestByInterest(int interestPerDay) {
        return loanRepository.sumInterestByInterest(interestPerDay);
    }

    public double aggregatePenaltyByInterest(int interestPerDay) {
        return loanRepository.sumPenaltyByInterest(interestPerDay);
    }

    public double aggregateRemainingAmountByCustomerId(String customerId) {
        return loanRepository.sumRemainingAmountByCustomerId(customerId);
    }

    public double aggregateInterestByCustomerId(String customerId) {
        return loanRepository.sumInterestByCustomerId(customerId);
    }

    public double aggregatePenaltyByCustomerId(String customerId) {
        return loanRepository.sumPenaltyByCustomerId(customerId);
    }


}