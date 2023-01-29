package org.example;

import org.example.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.List;

@TestConfiguration
public class TestConfig {

    @Autowired private PasswordEncoder encoder;

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {

        UserAccount tester = new UserAccount(
                "tester",
                encoder.encode("tester"),
                List.of("ROLE_ADMIN"),
                true);

        return new InMemoryUserDetailsManager(List.of(tester));
    }

}

