package htwberlin.webtech.recipemanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class RecipeManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeManagementAppApplication.class, args);
	}

}
