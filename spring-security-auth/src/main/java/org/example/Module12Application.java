package org.example;

import org.example.model.UserAccount;
import org.example.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Module12Application implements CommandLineRunner {

	@Autowired private UserAccountRepository repo;
	@Autowired private PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(Module12Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserAccount admin = new UserAccount(
				"admin",
				encoder.encode("admin"),
				List.of("ROLE_ADMIN"),
				true);
		repo.save(admin);
		UserAccount user = new UserAccount(
				"user",
				encoder.encode("user"),
				List.of("ROLE_USER"),
				true);
		repo.save(user);
		repo.findAll().forEach(System.out::println);
	}
}