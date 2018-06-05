package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

	@Bean
	public CommandLineRunner demo(ContactRepository repository) {
		return (args) -> {
			repository.save(new Contact("Jack", "Bauer"));
			repository.save(new Contact("Chloe", "O'Brian"));
			repository.save(new Contact("Kim", "Bauer"));
			repository.save(new Contact("David", "Palmer"));
			repository.save(new Contact("Michelle", "Dessler"));

			log.info("-------------------------------");
			for (Contact contact : repository.findAll()) {
				log.info(contact.toString());
			}
			log.info("--------------------------------------------");
		};
	}
}