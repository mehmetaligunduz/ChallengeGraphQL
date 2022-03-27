package com.emlakjet.ChallengeGraphQL.dao.transaction;

public interface TransactionDao {
    long create(Transaction transaction);
    Transaction getTransaction(Long id);
    Transaction getByBillNo(String billNo);
}
