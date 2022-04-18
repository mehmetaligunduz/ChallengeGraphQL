package com.emlakjet.ChallengeGraphQL.repository;

import com.emlakjet.ChallengeGraphQL.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
}
