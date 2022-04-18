package com.emlakjet.ChallengeGraphQL.dao.user;

import com.emlakjet.ChallengeGraphQL.domain.User;

public interface UserDao {
    long create (User user);
    User getUserByEmail(String email);
}
