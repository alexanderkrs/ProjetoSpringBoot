package br.ueg.Armas;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ueg.Armas.model.Arma;
import br.ueg.Armas.repository.ArmasRepository;

@SpringBootApplication
public class ArmasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmasApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(ArmasRepository repository) {
		return args -> {
			Arma a1 = new Arma(1,"Taurus","TS9",9);
			repository.save(a1);
			Arma a2 = new Arma(2,"Glock","G19",9);
		    repository.save(a2);
		};
	}

}
