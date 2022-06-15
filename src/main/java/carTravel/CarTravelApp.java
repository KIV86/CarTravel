package carTravel;

import carTravel.common.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarTravelApp {
    public static void main(String[] args) {
        SpringApplication.run(CarTravelApp.class, args);

        Bot myBot = new Bot();
        myBot.serve();
    }
}

