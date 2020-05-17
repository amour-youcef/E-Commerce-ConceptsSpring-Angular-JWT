package org.sid.lightecomv1.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class SpringBootDeploymentApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootDeploymentApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootDeploymentApplication.class, args);
	}
}
