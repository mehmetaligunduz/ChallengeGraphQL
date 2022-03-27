package com.emlakjet.ChallengeGraphQL.dao.transaction;

import com.emlakjet.ChallengeGraphQL.common.ResultEnumeration;
import com.emlakjet.ChallengeGraphQL.dao.BaseEntity;
import com.emlakjet.ChallengeGraphQL.dao.user.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transaction")
@Table(name = "transactions")
public class Transaction extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private String billNo;

    @Column(nullable = false)
    private String contentName;

    @Column(nullable = false)
    private String contentType;

    @Column(nullable = false)
    private double contentValue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResultEnumeration result;

    @ManyToOne
    @JoinColumn(
            name = "userId",
            referencedColumnName = "id"
    )
    private User user;
}
