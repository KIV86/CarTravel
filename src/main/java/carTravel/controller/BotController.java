package carTravel.controller;

import carTravel.config.CarTravelBotSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class BotController {
        private final CarTravelBotSender telegramBot;

        public BotController(CarTravelBotSender telegramBot) {
            this.telegramBot = telegramBot;
        }

        @PostMapping(value = "/")
        public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
            return telegramBot.onWebhookUpdateReceived(update);
        }
}
