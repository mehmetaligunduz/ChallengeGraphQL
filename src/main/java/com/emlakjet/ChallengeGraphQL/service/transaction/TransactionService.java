package com.emlakjet.ChallengeGraphQL.service.transaction;

import com.emlakjet.ChallengeGraphQL.common.ResultEnumeration;
import com.emlakjet.ChallengeGraphQL.dao.transaction.Transaction;
import com.emlakjet.ChallengeGraphQL.dao.user.User;
import com.emlakjet.ChallengeGraphQL.service.user.UserService;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
@Getter
@Builder
@EqualsAndHashCode
public class TransactionService {
    private String billNo;
    private String contentName;
    private String contentType;
    private double contentValue;
    private ResultEnumeration result;
    private String email;

    Transaction toTransaction(){
        return Transaction.builder()
                .billNo(getBillNo())
                .contentName(getContentName())
                .contentType(getContentType())
                .contentValue(getContentValue())
                .result(getResult())
                .build();

    }

    public static TransactionService valueOf(Transaction transaction){
        return TransactionService.builder()
                .billNo(transaction.getBillNo())
                .contentName(transaction.getContentName())
                .contentType(transaction.getContentType())
                .contentValue(transaction.getContentValue())
                .result(transaction.getResult())
                .build();
    }
}
