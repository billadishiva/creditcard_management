package cards.credit.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

/**
 * @author billa
 *
 */
@SpringBootApplication
@EntityScan("cards.credit.management.model")
@Component("cards.credit")
public class ManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

}
