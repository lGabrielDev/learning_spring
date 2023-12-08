package br.com.lGabrielDev.CepProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class CepProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CepProjectApplication.class, args);
	}

}