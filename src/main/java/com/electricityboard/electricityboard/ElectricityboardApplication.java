package com.electricityboard.electricityboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.electricityboard.electricityboard.repository.Repositoryuser;

@SpringBootApplication
@EntityScan("com.electricityboard.electricityboard.admin")
public class ElectricityboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricityboardApplication.class, args);
	}

}
