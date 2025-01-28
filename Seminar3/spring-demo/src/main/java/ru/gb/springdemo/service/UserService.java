package ru.gb.springdemo.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.springdemo.model.Profile;
import ru.gb.springdemo.model.User;
import ru.gb.springdemo.model.UserProfile;
import ru.gb.springdemo.repository.UserProfileRepository;
import ru.gb.springdemo.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final UserProfileRepository userProfileRepository;

    @PostConstruct
    public void createSomeUsers() {
        UserProfile profileAdmin = userProfileRepository.save( new UserProfile() );
        UserProfile profileReader = userProfileRepository.save( new UserProfile() );
        UserProfile profileUser = userProfileRepository.save( new UserProfile() );

        profileAdmin.setProfile( Profile.ADMIN.toString() );
        profileReader.setProfile( Profile.READER.toString() );
        profileUser.setProfile( Profile.USER.toString() );

        User userAdmin = userRepository.save( new User() );
        userAdmin.setName( "Moet" );
        userAdmin.setLogin( "Admin" );
        userAdmin.setPassword( "Admin" );
        userAdmin.setUserProfiles( new HashSet<>( Arrays.asList( profileAdmin, profileUser ) ) );

        User userUser = userRepository.save( new User() );
        userAdmin.setName( "Argo" );
        userAdmin.setLogin( "User" );
        userAdmin.setPassword( "User" );
        userAdmin.setUserProfiles( new HashSet<>( Arrays.asList(profileUser ) ) );

        User userReader = userRepository.save( new User() );
        userAdmin.setName( "Master" );
        userAdmin.setLogin( "Reader" );
        userAdmin.setPassword( "Reader" );
        userAdmin.setUserProfiles( new HashSet<>( Arrays.asList( profileReader ) ) );


    }
}
