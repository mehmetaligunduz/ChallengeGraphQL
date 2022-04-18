package com.emlakjet.ChallengeGraphQL.dao.transaction;

import com.emlakjet.ChallengeGraphQL.domain.Transaction;
import com.emlakjet.ChallengeGraphQL.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionDaoImpl implements TransactionDao{

    private final TransactionRepository transactionRepository;

    @Override
    public long create(Transaction transaction) {
       return transactionRepository.save(transaction).getId();
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.getById(id);
    }
}
