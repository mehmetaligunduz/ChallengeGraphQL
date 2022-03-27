package com.emlakjet.ChallengeGraphQL.controller.user;

import com.emlakjet.ChallengeGraphQL.common.PackageEnumeration;
import com.emlakjet.ChallengeGraphQL.service.user.UserService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private PackageEnumeration packageType;

    public UserService toUser(){
        return UserService.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .email(getEmail())
                .packageType(getPackageType())
                .build();
    }
}
