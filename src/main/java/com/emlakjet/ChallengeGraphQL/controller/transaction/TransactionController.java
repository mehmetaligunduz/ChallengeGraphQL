package com.emlakjet.ChallengeGraphQL.controller.transaction;

import com.emlakjet.ChallengeGraphQL.controller.user.UserResponse;
import com.emlakjet.ChallengeGraphQL.service.GraphQLService;
import com.emlakjet.ChallengeGraphQL.service.transaction.TransactionService;
import com.emlakjet.ChallengeGraphQL.service.transaction.TransactionServiceInterface;
import graphql.ExecutionResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionServiceInterface transactionServiceInterface;
    private final GraphQLService graphQLService;

    @PostMapping("/api/transaction")
    public ResponseEntity<UserResponse> create(@RequestBody TransactionRequest transactionRequest){
        TransactionService transactionService = transactionRequest.toTransaction();
        Long id = transactionServiceInterface.create(transactionService);
        UserResponse userResponse = UserResponse.valueOf(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }

    @PostMapping("/api/transactions")
    public ResponseEntity<Object> getAllTransaction(@RequestBody String query){
        ExecutionResult execution = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(execution, HttpStatus.OK);
    }
}
