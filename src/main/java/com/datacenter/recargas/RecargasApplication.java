package com.datacenter.recargas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@SpringBootApplication
public class RecargasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecargasApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(DataSource dataSource) {
		return args -> {
			ResourceDatabasePopulator schemaPopulator = new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
			schemaPopulator.execute(dataSource);

			ResourceDatabasePopulator dataPopulator = new ResourceDatabasePopulator(new ClassPathResource("data.sql"));
			dataPopulator.execute(dataSource);
		};
	}
}
