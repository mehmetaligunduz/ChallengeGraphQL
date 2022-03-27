package com.emlakjet.ChallengeGraphQL.dao.transaction;

import com.emlakjet.ChallengeGraphQL.common.ResultEnumeration;
import com.emlakjet.ChallengeGraphQL.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction getTransactionByBillNo(String billNo);
    List<Transaction> getTransactionByResult(ResultEnumeration result);
    List<Transaction> getTransactionByUserAndResult(User user, ResultEnumeration result);
}
