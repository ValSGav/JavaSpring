package ru.gb.springdemo.model;




import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;


@Entity
@Table(name = "USER_PROFILE")
@NoArgsConstructor
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROFILE", length = 15, nullable = false)
    private String Profile = "";

    @ManyToMany(mappedBy = "userProfiles")
    private Set<User> users;

}
