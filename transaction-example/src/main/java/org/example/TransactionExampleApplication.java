package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TransactionExampleApplication implements CommandLineRunner {

	@Autowired private CatService catService;

	public static void main(String[] args) {
		SpringApplication.run(TransactionExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello, Transactional");

		catService.printAllCats();

		Cat murka = new Cat(3L, "Мурка", "Бурманская");
		Cat tutankhamun = new Cat(4L, "Тутанхамон", "Сфинкс");

		try{
			catService.saveSomeCats(List.of(murka,tutankhamun));
		}
		catch (Exception e){
			System.out.println("Кот сломался");
		}

		System.out.println("После манипуляций");
		catService.printAllCats();

	}
}
