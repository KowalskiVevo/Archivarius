package ru.hostco.archivarius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.hostco.archivarius.controllers","ru.hostco.archivarius.soap_examples","ru.hostco.archivarius.config"})
public class ArchivariusApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArchivariusApplication.class, args);
	}
}
