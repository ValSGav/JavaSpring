package ru.gb.springdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.springdemo.model.Profile;
import ru.gb.springdemo.model.User;
import ru.gb.springdemo.model.UserProfile;
import ru.gb.springdemo.repository.UserProfileRepository;
import ru.gb.springdemo.repository.UserRepository;
import ru.gb.springdemo.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		UserService userService = SpringApplication.run(Application.class, args).getBean( UserService.class );
	}
}

