package com.emlakjet.ChallengeGraphQL.repository;

import com.emlakjet.ChallengeGraphQL.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
