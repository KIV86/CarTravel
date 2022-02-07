package com.github.KIV86.CarTravel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarTravelApp {

	public static void main(String[] args) {
		SpringApplication.run(CarTravelApp.class, args);
		System.out.println("Инициализация проекта");
	}

}
