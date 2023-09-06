package com.guilherme.authservertwo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserStoreConfig {

    @Bean
    UserDetailsService userDetailsService() {
        var userDetaisManager = new InMemoryUserDetailsManager();

        userDetaisManager.createUser(
                User.withUsername("guilherme.gorges")
                        .password("{noop}123")
                        .roles("USER")
                        .build());

        return userDetaisManager;
    }

}
