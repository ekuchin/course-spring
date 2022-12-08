package org.example.demojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

	@Autowired
	CatRepository repoCat;

	@Autowired
	KittenRepository repoKitten;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, JPA");

		Cat manul = new Cat ("Мурзик", "Манул");
		Cat sphynx = new Cat ("Рамзес", "Сфинкс");
		Cat brit = new Cat ("Эдуард", "Британец");

		repoCat.save(manul);
		repoCat.save(sphynx);
		repoCat.save(brit);

		Kitten first = new Kitten("Первый");
		Kitten second = new Kitten("Второй");

		first.setParent(manul);
		repoKitten.save(first);

		second.setParent(manul);
		repoKitten.save(second);

		repoKitten.save(first);

		System.out.println("Коты");
		repoCat.findAll().forEach(System.out::println);
		System.out.println("Котята");
		repoKitten.findAll().forEach(System.out::println);

	}
}
