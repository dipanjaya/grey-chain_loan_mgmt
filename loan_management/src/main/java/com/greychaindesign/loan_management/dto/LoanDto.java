package com.greychaindesign.loan_management.dto;


import com.greychaindesign.loan_management.model.Loan;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.StringJoiner;


@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class LoanDto {

    private Long id;
    private String customerId;
    private String lenderId;
    private double amount;
    private double remainingAmount;
    private String paymentDate;
    private int interestPerDay;
    private String dueDate;
    private double dueDatePenalty;

    public LoanDto(Loan loan){
        BeanUtils.copyProperties(loan, this);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LoanDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("customerId='" + customerId + "'")
                .add("lenderId='" + lenderId + "'")
                .add("amount=" + amount)
                .add("remainingAmount=" + remainingAmount)
                .add("paymentDate='" + paymentDate + "'")
                .add("interestPerDay=" + interestPerDay)
                .add("dueDate='" + dueDate + "'")
                .add("dueDatePenalty=" + dueDatePenalty)
                .toString();
    }
}
