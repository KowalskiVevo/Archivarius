package ru.hostco.archivarius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.hostco.archivarius.controllers")
public class ArchivariusApplication {
	public static void main(String[] args) {
		System.out.print("Запуск Архивариуса\n");
		SpringApplication.run(ArchivariusApplication.class, args);
	}
}
