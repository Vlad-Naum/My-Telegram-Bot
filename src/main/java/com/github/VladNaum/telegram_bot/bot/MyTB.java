package com.github.VladNaum.telegram_bot.bot;

import com.github.VladNaum.telegram_bot.exception.CountOfRequestException;
import com.github.VladNaum.telegram_bot.exception.IncorrectCityException;
import com.github.VladNaum.telegram_bot.command.CommandContainer;
import com.github.VladNaum.telegram_bot.repo.WeatherRepos;
import com.github.VladNaum.telegram_bot.service.SendBotMessage;
import com.github.VladNaum.telegram_bot.service.WeatherServiceImpl;
import com.github.VladNaum.telegram_bot.weather.JsonParser;
import com.github.VladNaum.telegram_bot.weather.Weather;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
=======
>>>>>>> heroku
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

=======
import java.time.Instant;
>>>>>>> heroku

@Component
public class MyTB extends TelegramLongPollingBot {

<<<<<<< HEAD
    @Value("${bot.username}")
    private String userName;

    @Value("${bot.token}")
    private String token;

    @Autowired
    private WeatherRepos weatherRepos;

=======
>>>>>>> heroku
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
            Integer date = update.getMessage().getDate();
            if(message.startsWith("/")){
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                container.retrievCommand(commandIdentifier).execute(update);
            }
            else{
                try {
<<<<<<< HEAD
                    if (requestCheck(message.toLowerCase())) {
                        Weather weather = JsonParser.parser(message.toLowerCase());
                        new WeatherServiceImpl(weatherRepos).save(weather);
                        new SendBotMessage(this)
                                .sendMessage(update.getMessage().getChatId().toString(), weather.toString());
                    }
                } catch (IncorrectCityException | CountOfRequestException e) {
=======
                    Weather weather = JsonParser.parser(message.toLowerCase());
                    weather.setDate(Instant.ofEpochSecond(date));
                    new SendBotMessage(this)
                            .sendMessage(update.getMessage().getChatId().toString(), weather.toString());
                } catch (IncorrectCityException e) {
>>>>>>> heroku
                    new SendBotMessage(this)
                            .sendMessage(update.getMessage().getChatId().toString(), e.getMessage());
                    e.printStackTrace();
                }

            }
        }
    }

    /*
    Метод requestCheck проверяет не превышен ли лимит запросов для данного города.
    Можно делать запросы для одного города не чаще 10 минут.
     */
    public boolean requestCheck(String city) throws CountOfRequestException{
        List<Weather> list = new WeatherServiceImpl(weatherRepos).getWeather();
        for (Weather weather : list) {
            if(weather.getCity().toLowerCase().equals(city) && weather.getDate().equals(Weather.formater.format(new Date()))){
                int time1 = Integer.parseInt(weather.getTime().split(":")[0]);
                int time2 = Integer.parseInt(Weather.formater2.format(new Date()).split(":")[0]);
                if(time2 == time1){
                    throw new CountOfRequestException();
                }
            }
        }
        return true;
    }

    @Override
    public String getBotUsername() {
        return System.getenv("username");
    }

    @Override
    public String getBotToken() {
        return System.getenv("token");
    }
}
