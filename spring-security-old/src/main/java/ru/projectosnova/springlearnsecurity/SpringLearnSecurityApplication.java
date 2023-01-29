package ru.projectosnova.springlearnsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.projectosnova.springlearnsecurity.entity.Cat;
import ru.projectosnova.springlearnsecurity.entity.UserAccount;
import ru.projectosnova.springlearnsecurity.repository.CatRepository;
import ru.projectosnova.springlearnsecurity.repository.UserAccountRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringLearnSecurityApplication implements CommandLineRunner {

	@Autowired
	private UserAccountRepository repoUser;
	@Autowired
	private CatRepository repoCat;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, Security");

		repoUser.save(new UserAccount("user", passwordEncoder.encode("password")));
		repoUser.save(new UserAccount("vasya", passwordEncoder.encode("V@sy@123")));

		repoCat.save(new Cat("Мурзик", "Манул"));
		repoCat.save(new Cat("Рамзес", "Сфинкс"));
		repoCat.save(new Cat("Эдуард", "Британец"));
		repoCat.save(new Cat("Мурка", "Беспородная"));

		System.out.println("Люди:");
		repoUser.findAll().forEach(System.out::println);
		System.out.println("Коты:");
		repoCat.findAll().forEach(System.out::println);

		UserAccount first = repoUser.findById("user").orElseThrow(()->new Exception("Нет такого пользователя."));
		UserAccount second = repoUser.findById("vasya").orElseThrow(()->new Exception("Нет такого пользователя."));

//		System.out.println(passwordEncoder.matches("password", first.getPassword()));
//		System.out.println(passwordEncoder.matches("password", second.getPassword()));

		List<Cat> cats = new ArrayList<>(repoCat.findAll());
		System.out.println(cats);

	}
}
