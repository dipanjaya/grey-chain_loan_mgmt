package com.greychaindesign.loan_management.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.StringJoiner;

@Getter
@Setter
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String customerId;
    @Column
    private String lenderId;
    @Column
    private double amount;
    @Column
    private double remainingAmount;
    @Column
    private String paymentDate;
    @Column
    private int interestPerDay;
    @Column
    private String dueDate;
    @Column
    private double dueDatePenalty;

    @Override
    public String toString() {
        return new StringJoiner(", ", Loan.class.getSimpleName() + "[", "]")
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
