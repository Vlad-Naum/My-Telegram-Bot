package com.github.VladNaum.telegram_bot.bot;

import com.github.VladNaum.telegram_bot.command.CommandContainer;
import com.github.VladNaum.telegram_bot.service.SendBotMessage;
import com.github.VladNaum.telegram_bot.weather.JsonParser;
import com.github.VladNaum.telegram_bot.weather.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.VladNaum.telegram_bot.command.CommandName.NO;

@Component
public class MyTB extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String userName;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer container;

    public MyTB(){
        this.container = new CommandContainer(new SendBotMessage(this));
    }

    @Override
    /*
    Метод onUpdateReceived - точка входа, куда будут поступать сообщения от пользователей.
    Отсюда будет идти вся новая логика
    */
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String message = update.getMessage().getText().trim();
            if(message.startsWith("/")){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                container.retrievCommand(commandIdentifier).execute(update);
            }
            else{
                Weather weather = JsonParser.parser(message.toLowerCase());
                new SendBotMessage(this).sendMessage(update.getMessage().getChatId().toString(), weather.toString());
                //container.retrievCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
