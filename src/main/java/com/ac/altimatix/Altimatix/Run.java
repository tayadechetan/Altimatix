package com.ac.altimatix.Altimatix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ac.altimatix")
@SpringBootApplication
public class Run extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Run.class);
	}

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }

}
