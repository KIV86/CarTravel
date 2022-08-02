package carTravel.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

import javax.validation.constraints.NotBlank;


@Configuration
@Validated
@Data
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    private String userName;
    @NotBlank
    private String botToken;
    private String webHookPath;
    private String proxyType;
    private String proxyHost;
    private Integer proxyPort;

}
