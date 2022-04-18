package com.emlakjet.ChallengeGraphQL.service.user;

import com.emlakjet.ChallengeGraphQL.common.PackageEnumeration;
import com.emlakjet.ChallengeGraphQL.domain.User;
import com.emlakjet.ChallengeGraphQL.dao.user.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServiceInterface{
    private final double PREMIUM = 100;
    private final double GOLD = 50;
    private final double STANDART = 100;
    private final UserDao userDao;

    @Override
    public Long create(UserService userService) {
        User user = userService.toUser();
        double amount = helperPackageLimitDetermine(user.getPackageType());
        user.setAmount(amount);
        user.setRemainingAmount(amount);
        return userDao.create(user);
    }

    private double helperPackageLimitDetermine(PackageEnumeration packageType){
        if (packageType.equals(PackageEnumeration.Premium))
            return PREMIUM;
        else if (packageType.equals(PackageEnumeration.Gold))
            return GOLD;
        return STANDART;
    }
}
