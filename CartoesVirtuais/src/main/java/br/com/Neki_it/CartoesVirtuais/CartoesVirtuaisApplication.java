package br.com.Neki_it.CartoesVirtuais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.Neki_it.CartoesVirtuais")
public class CartoesVirtuaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartoesVirtuaisApplication.class, args);
	}

}
