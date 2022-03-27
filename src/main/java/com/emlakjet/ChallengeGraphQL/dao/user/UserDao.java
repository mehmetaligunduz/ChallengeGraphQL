package com.emlakjet.ChallengeGraphQL.dao.user;

public interface UserDao {
    long create (User user);
    User getUserByEmail(String email);
}
