package com.emlakjet.ChallengeGraphQL.controller.transaction;

import com.emlakjet.ChallengeGraphQL.controller.user.UserResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Long id;

    public static TransactionResponse valueOf(Long id){
        return TransactionResponse.builder()
                .id(id)
                .build();
    }
}
