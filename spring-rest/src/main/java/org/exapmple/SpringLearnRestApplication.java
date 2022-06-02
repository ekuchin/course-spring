package org.exapmple;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLearnRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnRestApplication.class, args);
	}

	@Bean
	public CommandLineRunner presetCat(CatRepository repository){
		return args -> {
			repository.save(new Cat(1L, "Мурзик", "Манул", 12L,1L));
			repository.save(new Cat(2L, "Рамзес", "Сфинкс", 2L,2L));
			repository.save(new Cat(3L, "Эдуард", "Британец", 5L,3L));
		};
	}

	@Bean
	public CommandLineRunner presetPlace(PlaceRepository repository){
		return args -> {
			repository.save(new Place(1L, "Лес"));
			repository.save(new Place(2L, "Пирамида"));
			repository.save(new Place(3L, "Замок"));
		};
	}

}
