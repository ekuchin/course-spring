package org.example;

import jakarta.annotation.PostConstruct;
import org.example.model.Cat;
import org.example.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module12Application implements CommandLineRunner {

	@Autowired private CatRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Module12Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Cat("Мурзик",10,true));
		repo.save(new Cat("Барсик",5,false));
		repo.save(new Cat("Мурка",2,true));
	}
}