package carTravel.config;

import carTravel.common.BotConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
@RequiredArgsConstructor
public class BotOptionsConfig {
    private final BotConfig botConfig;

    @Bean
    public DefaultBotOptions defaultBotOptions() {
        DefaultBotOptions options = new DefaultBotOptions();
        options.setProxyPort(botConfig.getProxyPort());
        options.setProxyHost(botConfig.getProxyHost());
        options.setProxyType(DefaultBotOptions.ProxyType.valueOf(botConfig.getProxyType()));

        return options;
    }
}
