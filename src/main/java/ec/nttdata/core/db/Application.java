package ec.nttdata.core.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("ec.nttdata.core.db.*")
@ComponentScan(basePackages = { "ec.nttdata.core.db.*" })
@EntityScan("ec.nttdata.core.db.*") 
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
