package com.greychaindesign.loan_management.repo;

import com.greychaindesign.loan_management.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    //validation purpose for aggregate methods
    boolean existsByLenderId(String lenderId);
    boolean existsByCustomerId(String lenderId);

    /*lender*/
    @Query("SELECT SUM(l.remainingAmount) FROM Loan l WHERE l.lenderId = ?1")
    double sumRemainingAmountByLender(String lenderId);

    @Query("SELECT SUM(l.interestPerDay) FROM Loan l WHERE l.lenderId = ?1")
    double sumInterestByLender(String lenderId);

    @Query("SELECT SUM(l.dueDatePenalty) FROM Loan l WHERE l.lenderId = ?1")
    double sumPenaltyByLender(String lenderId);

     /*Interest*/
    @Query("SELECT SUM(l.remainingAmount) FROM Loan l WHERE l.interestPerDay = ?1")
    double sumRemainingAmountByInterest(int interestPerDay);

    @Query("SELECT SUM(l.interestPerDay) FROM Loan l WHERE l.interestPerDay = ?1")
    double sumInterestByInterest(int interestPerDay);

    @Query("SELECT SUM(l.dueDatePenalty) FROM Loan l WHERE l.interestPerDay = ?1")
    double sumPenaltyByInterest(int interestPerDay);

    /* Customer ID*/
    @Query("SELECT SUM(l.remainingAmount) FROM Loan l WHERE l.customerId = ?1")
    double sumRemainingAmountByCustomerId(String customerId);

    @Query("SELECT SUM(l.interestPerDay) FROM Loan l WHERE l.customerId = ?1")
    double sumInterestByCustomerId(String customerId);

    @Query("SELECT SUM(l.dueDatePenalty) FROM Loan l WHERE l.customerId = ?1")
    double sumPenaltyByCustomerId(String customerId);

}
