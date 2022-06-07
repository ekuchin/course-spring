package org.example.demojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoJpaApplication implements CommandLineRunner {

	@Autowired CatRepository repoCat;
	@Autowired BowlRepository repoBowl;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, JPA");

		Cat manul = new Cat ("Мурзик", "Манул");
		Cat sphynx = new Cat ("Рамзес", "Сфинкс");
		Cat brit = new Cat ("Эдуард", "Британец");

		Bowl bowl = new Bowl("Тазик");
		manul.setBowl(bowl);

		repoCat.save(manul);
		repoCat.save(sphynx);
		repoCat.save(brit);

		System.out.println("Коты");
		repoCat.findAll().forEach(System.out::println);
		System.out.println("Миски");
		repoBowl.findAll().forEach(System.out::println);

		Bowl newbowl=repoBowl.findById(2L).orElseThrow(()->new Exception("Нет такой миски."));
		Cat bowlowner = newbowl.getCat();
		System.out.println("Хозяин миски: "+bowlowner.getName());

		System.out.println("Удаляем:");
		repoCat.delete(manul);

		System.out.println("Коты:");
		repoCat.findAll().forEach(System.out::println);
		System.out.println("Миски:");
		repoBowl.findAll().forEach(System.out::println);

	}
}
