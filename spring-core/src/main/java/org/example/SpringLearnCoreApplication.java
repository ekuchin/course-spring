package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class SpringLearnCoreApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnCoreApplication.class, args);
	}

	@Autowired private Manul manul;
	@Autowired private Manul cat1;
	@Autowired private Manul cat2;
	@Autowired private Sphynx cat3;

	@Autowired private SleepingPlace place;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Hello, Spring");

		System.out.println(manul.getName());

		System.out.println("Hello, "+cat1.getName());
		System.out.println("Hello, "+cat2.getName());

		System.out.println("Hello, "+cat3.getName());

		// Сравнение бинов и понимание области действия

		System.out.println(cat1==cat2);

		//Внедрение зависимостей

		System.out.println(place.getStatus());
	}


	@Bean(name="sphynx", initMethod = "init", destroyMethod = "destroy") //Если не указать, то в качестве имени будет использоваться имя метода
	@Scope("prototype")
	public Sphynx sphynx(){
		return new Sphynx("Рамзес");
	}

}
