package com.emlakjet.ChallengeGraphQL.service;

import com.emlakjet.ChallengeGraphQL.service.datafetcher.AllAcceptedTransactionsDataFetcher;
import com.emlakjet.ChallengeGraphQL.service.datafetcher.AllRejectedTransactionsDataFetcher;
import com.emlakjet.ChallengeGraphQL.dao.transaction.TransactionRepository;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;


@Service
public class GraphQLService {

    @Value("classpath:transactions.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllAcceptedTransactionsDataFetcher allAcceptedTransactionsDataFetcher;

    @Autowired
    private AllRejectedTransactionsDataFetcher allRejectedTransactionsDataFetcher;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostConstruct
    private void loadSchema() throws IOException {
        //Load Books into the Book Repository
        // get the schema
        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                            .dataFetcher("allAcceptedTransactions", allAcceptedTransactionsDataFetcher)
                            .dataFetcher("allRejectedTransactions", allRejectedTransactionsDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
