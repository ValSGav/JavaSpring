package ru.gb.springdemo.security;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import ru.gb.springdemo.model.Profile;
import ru.gb.springdemo.model.User;
import ru.gb.springdemo.model.UserProfile;
import ru.gb.springdemo.repository.UserProfileRepository;
import ru.gb.springdemo.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class customUserDetailService implements UserDetailsService {


    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository
                .findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));



        return new org.springframework.security.core.userdetails.User(user.getLogin()
                , user.getPassword()
                , user.getUserProfiles()
                    .stream()
                        .map(profile -> new SimpleGrantedAuthority(profile.getProfile().toString()))
                        .toList());
    }
}
