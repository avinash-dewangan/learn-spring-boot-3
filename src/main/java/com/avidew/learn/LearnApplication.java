package com.avidew.learn;

import com.avidew.learn.auth.AuthenticationService;
import com.avidew.learn.auth.RegisterRequest;
import com.avidew.learn.user.Role;
import com.avidew.learn.user.User;
import com.avidew.learn.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service, UserRepository repository
	) {
		return args -> {
			Optional<User> emailIdAdmin = repository.findByEmail("admin@mail.com");
			if(emailIdAdmin.isPresent()) return;
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());
			Optional<User> emailIdManager = repository.findByEmail("manager@mail.com");
			if(emailIdManager.isPresent()) return;
			var manager = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("manager@mail.com")
					.password("password")
					.role(Role.MANAGER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}
}
