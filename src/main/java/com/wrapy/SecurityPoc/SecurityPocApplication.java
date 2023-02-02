package com.wrapy.SecurityPoc;

import com.wrapy.SecurityPoc.models.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.wrapy.SecurityPoc.models")
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityPocApplication.class, args);
	}

}
