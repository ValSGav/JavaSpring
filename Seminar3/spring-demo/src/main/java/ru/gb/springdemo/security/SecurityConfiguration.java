package ru.gb.springdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import ru.gb.springdemo.model.Profile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration   {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(source -> {
            Map<String, Object> resourceAccess = source.getClaim("realm_access");
            List<String> roles = (List<String>) resourceAccess.get("roles");

            return roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        });

        return httpSecurity
                .authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/ui/books/**").authenticated()
                        .requestMatchers("/ui/issues/**").hasAuthority(Profile.ADMIN.toString())
                        .requestMatchers("/ui/readers/**").hasAuthority( Profile.READER.toString() )
                        .anyRequest().denyAll()
               )
                .oauth2ResourceServer(configurer -> configurer
                        .jwt(jwtConfigurer -> jwtConfigurer
                                .jwtAuthenticationConverter(converter))
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
