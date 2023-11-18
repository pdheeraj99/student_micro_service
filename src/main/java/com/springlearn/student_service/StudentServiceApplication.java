package com.springlearn.student_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({ "com.springlearn.controller", "com.springlearn.service" })
@EntityScan("com.springlearn.entity")
@EnableJpaRepositories("com.springlearn.repository")
public class StudentServiceApplication {

	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	// 1. WebClient in Spring WebFlux: It's a non-blocking, reactive HTTP client
	// within the Spring WebFlux framework.
	// 2. Configuration via Code: The WebClient bean is created and configured,
	// setting the baseUrl to an address retrieved from application properties.
	// 3. Dependency Injection: Autowiring allows the WebClient bean to be injected
	// into classes like StudentService for making HTTP requests.
	// 4. Request Handling: The StudentService utilizes the WebClient to perform
	// asynchronous requests to external services, like the address service.
	// 5. Reactive Approach: This tool facilitates asynchronous HTTP interactions
	// in reactive manner, commonly employed in Spring WebFlux applications for
	// external service communication.

	@Bean
	public WebClient webClient() {
		WebClient webClient = WebClient.builder()
				.baseUrl(addressServiceUrl).build();

		return webClient;
	}

}
