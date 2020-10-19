package pl.tmassalski.vetservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class VetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetServiceApplication.class, args);
	}

}
