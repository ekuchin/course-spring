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

		System.out.println("Коты");
		repoCat.findAll().forEach(System.out::println);

		System.out.println("Манулы:");
		repoCat.findByBreed("Манул").forEach(System.out::println);

		System.out.println("Снова Манулы:");
		repoCat.findSomeManuls().forEach(System.out::println);


		Cat dbCat = repoCat.findById(1L).orElseThrow();

		dbCat.setName("Барсик");
		repoCat.save(dbCat);

		repoCat.deleteById(2L);

		System.out.println("Финальные коты");
		repoCat.findAll().forEach(System.out::println);

	}
}
