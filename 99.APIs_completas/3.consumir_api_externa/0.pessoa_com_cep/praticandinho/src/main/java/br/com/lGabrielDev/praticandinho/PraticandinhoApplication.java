package br.com.lGabrielDev.praticandinho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PraticandinhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraticandinhoApplication.class, args);
	}

}
