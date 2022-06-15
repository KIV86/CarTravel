package carTravel.common;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetWebhook;

import static carTravel.common.Constants.Fields.http;
import static carTravel.common.Constants.Fields.token;

public class Bot {
    private final TelegramBot bot = new TelegramBot(System.getenv("BOT_TOKEN"));

    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
        SetWebhook request = new SetWebhook()
                .url(http)
                .certificate(new byte[]{}) // byte[]
        ; // or file
    }

    private void process(Update update) {
        Message message = update.message();
        CallbackQuery callbackQuery = update.callbackQuery();
        InlineQuery inlineQuery = update.inlineQuery();

        BaseRequest request = null;

        if (message != null) {
            long chartId = message.chat().id();
            request = new SendMessage(chartId, "Hello");
        }
        if (request != null) {

            bot.execute(request);
        }
    }
}





