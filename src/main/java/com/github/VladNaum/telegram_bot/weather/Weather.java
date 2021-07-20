package com.github.VladNaum.telegram_bot.weather;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Weather {
    private String city;
    private String description;
    private int temperature;
    private int windSpeed;
    private Date date;

    public Weather(String city, String description, int temperature, int windSpeed, Date date) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.YYYY");
        SimpleDateFormat formater2 = new SimpleDateFormat("HH:mm:ss");
        return city + "\n" + formater.format(date) + "\n"
                + formater2.format(date) + "\nТемпература: " + temperature
                + " C\nСкорость ветра: " + windSpeed + " м/с" + "\n"
                + description.substring(0,1).toUpperCase() + description.substring(1);

    }
}
