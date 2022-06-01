package ru.projectosnova.springlearnaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnAopApplication implements CommandLineRunner {

	@Autowired
	private Cat cat;

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		System.out.println("Hello, AOP");
		cat.sleep();
		cat.eat();
		cat.jump();
		cat.crush();
	}
}
