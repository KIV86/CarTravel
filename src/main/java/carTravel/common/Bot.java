/*
package carTravel.common;

import lombok.Data;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Data
public class Bot extends TelegramWebhookBot {
    Constants constants;


    @Override

    public String getBotUsername() {
        return constants.getBotName();
    }

    @Override
    public String getBotToken() {
        return constants.getToken();
    }

    */
/**
     * обрабатывает входящий апдейт
     *//*

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

         Message message =update.getMessage();
         return message;
    }

    @Override
    public String getBotPath() {
        return constants.getHttp();
    }
}

*/




