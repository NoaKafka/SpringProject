package com.bridge.User.Data;

import lombok.*;

import javax.persistence.*;

@Entity(name="user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long seq;

    @Column(nullable = false, unique = true, length = 30)
    private String userId;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(nullable = false)
    private String password;

}
