package dev.wagnercardoso.qr_api.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dev.wagnercardoso") // Possibilita a utilização do Spring em outros pacotes que não o mesmo do arquivo main
public class QrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrApiApplication.class, args);
	}

}
