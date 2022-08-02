package carTravel.common;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;


public class Bot extends DefaultAbsSender {

    public Bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
//        return Constants.Fields.token;
return getBaseUrl();
    }
}





