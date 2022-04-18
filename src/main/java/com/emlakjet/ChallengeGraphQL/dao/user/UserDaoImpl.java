package com.emlakjet.ChallengeGraphQL.dao.user;

import com.emlakjet.ChallengeGraphQL.domain.User;
import com.emlakjet.ChallengeGraphQL.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao{
    private final UserRepository userRepository;
    @Override
    public long create(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
