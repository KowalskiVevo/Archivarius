package ru.hostco.archivarius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"ru.hostco.archivarius.controllers","ru.hostco.archivarius.soap_examples","ru.hostco.archivarius.config","ru.hostco.archivarius.models"})
@EnableSwagger2
@EnableFeignClients
public class ArchivariusApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArchivariusApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ru.hostco.archivarius")).build();
	}
}
