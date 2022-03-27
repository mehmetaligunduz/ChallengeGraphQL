package com.emlakjet.ChallengeGraphQL.dao.transaction;

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

    @Override
    public Transaction getByBillNo(String billNo) {
        return transactionRepository.getTransactionByBillNo(billNo);
    }
}
