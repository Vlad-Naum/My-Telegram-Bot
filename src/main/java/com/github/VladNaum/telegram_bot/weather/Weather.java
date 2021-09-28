package com.github.VladNaum.telegram_bot.weather;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Weather {
    private final String city;
    private final String description;
    private final int temperature;
    private final int windSpeed;
    private Instant date;

    public Weather(String city, String description, int temperature, int windSpeed) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withZone(ZoneId.of("Europe/Moscow"));
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.of("Europe/Moscow"));
        return city + "\n" + formatter.format(date) + "\n"
                + formatter2.format(date) + "\nТемпература: " + temperature
                + " C\nСкорость ветра: " + windSpeed + " м/с" + "\n"
                + description.substring(0,1).toUpperCase() + description.substring(1);

    }
}
