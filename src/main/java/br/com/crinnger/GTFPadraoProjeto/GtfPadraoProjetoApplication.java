package br.com.crinnger.GTFPadraoProjeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GtfPadraoProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtfPadraoProjetoApplication.class, args);
	}

}
