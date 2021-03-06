package com.emlakjet.ChallengeGraphQL.domain;

import com.emlakjet.ChallengeGraphQL.common.PackageEnumeration;
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
@Table(name = "users", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})

public class User extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, name = "email")
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
