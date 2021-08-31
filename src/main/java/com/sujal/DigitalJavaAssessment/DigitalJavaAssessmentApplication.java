package com.sujal.DigitalJavaAssessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class DigitalJavaAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalJavaAssessmentApplication.class, args);
	}

}
