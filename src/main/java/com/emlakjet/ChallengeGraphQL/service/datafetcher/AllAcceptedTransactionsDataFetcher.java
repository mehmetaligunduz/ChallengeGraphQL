package com.emlakjet.ChallengeGraphQL.service.datafetcher;

import com.emlakjet.ChallengeGraphQL.common.ResultEnumeration;
import com.emlakjet.ChallengeGraphQL.domain.Transaction;
import com.emlakjet.ChallengeGraphQL.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AllAcceptedTransactionsDataFetcher implements DataFetcher<List<Transaction>> {

    private  final UserRepository userRepository;

    @Override
    public List<Transaction> get(DataFetchingEnvironment dataFetchingEnvironment) {
        String email = dataFetchingEnvironment.getArgument("email");
        return userRepository.getUserByEmail(email).getTransactionList().stream().filter(t -> t.getResult().equals(ResultEnumeration.Accepted)).collect(Collectors.toList());
}
}
