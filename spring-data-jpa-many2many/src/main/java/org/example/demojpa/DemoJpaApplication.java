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
	PlaceRepository repoPlace;

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, JPA");

		Cat manul = new Cat ("Мурзик", "Манул");
		Cat sphynx = new Cat ("Рамзес", "Сфинкс");
		Cat brit = new Cat ("Эдуард", "Британец");

		Place bed = new Place("Кровать");
		Place chair = new Place("Стул");
		Place cupboard = new Place("Шкаф");

		repoCat.save(manul);
		repoCat.save(sphynx);
		repoCat.save(brit);

		repoPlace.save(bed);
		repoPlace.save(chair);
		repoPlace.save(cupboard);

		manul.setPlaces(Arrays.asList(bed,cupboard));
		sphynx.setPlaces(Arrays.asList(bed, chair));

		repoCat.save(manul);
		repoCat.save(sphynx);

		System.out.println("Коты");
		repoCat.findAll().forEach(System.out::println);
		System.out.println("Лежанки");
		repoPlace.findAll().forEach(System.out::println);

		

	}
}
