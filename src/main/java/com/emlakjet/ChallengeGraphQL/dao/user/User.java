package com.emlakjet.ChallengeGraphQL.dao.user;

import com.emlakjet.ChallengeGraphQL.dao.BaseEntity;
import com.emlakjet.ChallengeGraphQL.common.PackageEnumeration;
import com.emlakjet.ChallengeGraphQL.dao.transaction.Transaction;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double remainingAmount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PackageEnumeration packageType;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Transaction> transactionList;
}
