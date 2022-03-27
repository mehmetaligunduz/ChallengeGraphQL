package com.emlakjet.ChallengeGraphQL.controller.transaction;

import com.emlakjet.ChallengeGraphQL.common.ResultEnumeration;
import com.emlakjet.ChallengeGraphQL.service.transaction.TransactionService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    private String billNo;
    private String contentName;
    private String contentType;
    private double contentValue;
    private ResultEnumeration result;
    private String email;

    public TransactionService toTransaction(){
        return TransactionService.builder()
                .billNo(getBillNo())
                .contentName(getContentName())
                .contentType(getContentType())
                .contentValue(getContentValue())
                .result(getResult())
                .email(getEmail())
                .build();
    }
}
