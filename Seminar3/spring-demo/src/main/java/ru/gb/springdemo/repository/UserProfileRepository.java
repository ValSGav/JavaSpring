package ru.gb.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springdemo.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
