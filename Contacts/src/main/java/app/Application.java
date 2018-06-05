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
			// save a couple of customers
			repository.save(new Contact("Jack", "Bauer"));
			repository.save(new Contact("Chloe", "O'Brian"));
			repository.save(new Contact("Kim", "Bauer"));
			repository.save(new Contact("David", "Palmer"));
			repository.save(new Contact("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Contact contact : repository.findAll()) {
				log.info(contact.toString());
			}
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}