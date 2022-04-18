package com.emlakjet.ChallengeGraphQL.service.user;

import com.emlakjet.ChallengeGraphQL.common.PackageEnumeration;
import com.emlakjet.ChallengeGraphQL.domain.User;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class UserService {
    private String firstName;
    private String lastName;
    private String email;
    private double amount;
    private double remainingAmount;
    private PackageEnumeration packageType;

    User toUser() {
        return User.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .email(getEmail())
                .amount(getAmount())
                .remainingAmount(getRemainingAmount())
                .packageType(getPackageType())
                .build();
    }

    public static UserService valueOf(User user) {
        return UserService.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .amount(user.getAmount())
                .remainingAmount(user.getRemainingAmount())
                .packageType(user.getPackageType())
                .build();
    }
}
