package com.emlakjet.ChallengeGraphQL.service.transaction;

import com.emlakjet.ChallengeGraphQL.common.ResultEnumeration;
import com.emlakjet.ChallengeGraphQL.dao.transaction.Transaction;
import com.emlakjet.ChallengeGraphQL.dao.transaction.TransactionDao;
import com.emlakjet.ChallengeGraphQL.dao.user.User;
import com.emlakjet.ChallengeGraphQL.dao.user.UserDao;
import com.emlakjet.ChallengeGraphQL.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.UserTransaction;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionServiceInterface {
    private final TransactionDao transactionDao;
    private final UserDao userDao;


    @Override
    public long create(TransactionService transactionService) {
        Transaction transaction = transactionService.toTransaction();
        User user = userDao.getUserByEmail(transactionService.getEmail());
        double limitCalculation = user.getRemainingAmount() - transactionService.getContentValue();
        if (limitCalculation >= 0) {
            transaction.setResult(ResultEnumeration.Accepted);
            user.setRemainingAmount(limitCalculation);
        } else
            transaction.setResult(ResultEnumeration.Rejected);
        transaction.setUser(userDao.getUserByEmail(transactionService.getEmail()));
        return transactionDao.create(transaction);
    }
}
