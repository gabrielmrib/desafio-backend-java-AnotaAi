package com.gabriel.desafio_anota_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class DesafioAnotaAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioAnotaAiApplication.class, args);
	}

}
// https://youtu.be/a3tPHH8uwPc?si=C6goLwJT-ETV8sZv&t=4414
