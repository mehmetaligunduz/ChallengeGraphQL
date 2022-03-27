package com.emlakjet.ChallengeGraphQL.controller.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;

    public static UserResponse valueOf(Long id){
        return UserResponse.builder()
                .id(id)
                .build();
    }
}
