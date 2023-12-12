package project.zelda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "project.zelda.models")
@EnableJpaRepositories(basePackages = "project.zelda.repository")
public class ZeldaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeldaProjectApplication.class, args);
	}

}
