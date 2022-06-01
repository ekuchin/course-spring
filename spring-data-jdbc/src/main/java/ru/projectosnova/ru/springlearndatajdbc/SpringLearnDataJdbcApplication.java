package ru.projectosnova.ru.springlearndatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringLearnDataJdbcApplication implements CommandLineRunner {

	@Autowired
	CatDao jdbc;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnDataJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	jdbc.save(new Cat(3L, "Эдуард", "Британец"));

	List<Cat> cats = jdbc.findAll();
	cats.stream().forEach(cat -> System.out.println(cat.toString()));

	Cat cat =jdbc.findOne(2L);
	System.out.println(cat.toString());

	jdbc.delete(2L);
	cats = jdbc.findAll();
	cats.stream().forEach(cat1 -> System.out.println(cat1.toString()));



	}
}
