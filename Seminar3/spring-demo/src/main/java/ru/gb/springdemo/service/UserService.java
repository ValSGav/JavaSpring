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

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @PostConstruct
    private void createSomeUsers() {
        UserProfile profileAdmin = new UserProfile();
        UserProfile profileReader = new UserProfile();
        UserProfile profileUser = new UserProfile();

        profileAdmin.setProfile(Profile.ADMIN.toString());
        profileReader.setProfile(Profile.READER.toString());
        profileUser.setProfile(Profile.USER.toString());

        profileAdmin = userProfileRepository.save(profileAdmin);
        profileUser = userProfileRepository.save(profileUser);
        profileReader = userProfileRepository.save(profileReader);

        User userAdmin = new User();
        userAdmin.setName("Moet");
        userAdmin.setLogin("Admin");
        userAdmin.setPassword("Admin");
        userAdmin.setUserProfiles(new HashSet<>(Arrays.asList(profileAdmin)));
        userAdmin = userRepository.save(userAdmin);

        User userUser = new User();
        userUser.setName("Argo");
        userUser.setLogin("User");
        userUser.setPassword("User");
        userUser.setUserProfiles(new HashSet<>(Arrays.asList(profileUser)));
        userUser = userRepository.save(userUser);

        User userReader = new User();
        userReader.setName("Master");
        userReader.setLogin("Reader");
        userReader.setPassword("Reader");
        userReader.setUserProfiles(new HashSet<>(Arrays.asList(profileReader)));
        userReader = userRepository.save(userReader);


    }
}
