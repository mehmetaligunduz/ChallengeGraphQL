package com.emlakjet.ChallengeGraphQL.dao.transaction;

import com.emlakjet.ChallengeGraphQL.domain.Transaction;

public interface TransactionDao {
    long create(Transaction transaction);
    Transaction getTransaction(Long id);
}
