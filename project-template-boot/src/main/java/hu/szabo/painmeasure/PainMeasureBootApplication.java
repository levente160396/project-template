package hu.szabo.painmeasure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
@ComponentScan("hu.szabo")
@EnableJpaRepositories(basePackages = "hu.szabo")
@EntityScan(basePackages = "hu.szabo")
@EnableScheduling
public class PainMeasureBootApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PainMeasureBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PainMeasureBootApplication.class, args);
	}
}
