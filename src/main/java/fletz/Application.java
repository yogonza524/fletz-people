package fletz;

import fletz.domain.dto.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import reactor.core.publisher.Flux;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"fletz"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
    List<Person> personsDummy() {
	    return Flux.just(
                Person.builder().name("Gonzalo").lastName("Mendoza").id("1").build(),
                Person.builder().name("Pepe").lastName("Sanchez").id("2").build(),
                Person.builder().name("Mauricio").lastName("Macri").id("3").build()
                ).collectList().block();
    }
}
