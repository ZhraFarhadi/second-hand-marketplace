package com.secondhand.backend.entity;

import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "username", nullable = false, unique = true, length = 30)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true, length = 11)
    private String phoneNumber;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 20)
    private Role role = Role.USER;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", nullable = false, length = 20)
    private AccountStatus accountStatus = AccountStatus.ACTIVE;

    @OneToMany(mappedBy = "seller")
    private List<Advertisement> advertisements = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<AdminReview> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "buyer")
    private List<Conversation> buyerConversations = new ArrayList<>();

    @OneToMany(mappedBy = "seller")
    private List<Conversation> sellerConversations = new ArrayList<>();

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Message> receivedMessages = new ArrayList<>();

    @OneToMany(mappedBy = "seller")
    private List<SellerRating> receivedRatings = new ArrayList<>();

    @OneToMany(mappedBy = "reviewer")
    private List<SellerRating> givenRatings = new ArrayList<>();


}
