package carTravel;

import carTravel.common.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.time.LocalDateTime;

@SpringBootApplication
@ComponentScan(basePackages = "carTravel")
@EnableAspectJAutoProxy
public class CarTravelApp {
    public static void main(String[] args) {
        SpringApplication.run(CarTravelApp.class, args);
        System.out.println(LocalDateTime.now());
//        Bot myBot = new Bot();
    }
}
