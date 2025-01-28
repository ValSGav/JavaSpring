package ru.gb.springdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
@Schema(description = "Пользователи сервиса")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PROFILES")
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_PROFILES"
            , joinColumns = @JoinColumn(name = "USER_ID")
            , inverseJoinColumns = @JoinColumn(name = "USER_PROFILE_ID")
    )
    private Set<UserProfile> userProfiles;

}
