package br.com.fiap.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan({"br.com.fiap.shopping"})
public class ShoppingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}
}
