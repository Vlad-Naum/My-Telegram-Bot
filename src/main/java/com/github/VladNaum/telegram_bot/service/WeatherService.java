package com.github.VladNaum.telegram_bot.service;

import com.github.VladNaum.telegram_bot.weather.Weather;

import java.util.List;
import java.util.Optional;

public interface WeatherService {

    void save(Weather weather);

    List<Weather> getWeather();
}
