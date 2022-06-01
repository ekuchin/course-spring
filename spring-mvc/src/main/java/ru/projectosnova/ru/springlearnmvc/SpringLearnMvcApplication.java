package ru.projectosnova.ru.springlearnmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SpringLearnMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnMvcApplication.class, args);
	}
}
