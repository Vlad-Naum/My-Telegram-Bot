package com.github.VladNaum.telegram_bot.service;

import com.github.VladNaum.telegram_bot.repo.WeatherRepos;
import com.github.VladNaum.telegram_bot.weather.Weather;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepos weatherRepos;

    @Autowired
    public WeatherServiceImpl(WeatherRepos weatherRepos) {
        this.weatherRepos = weatherRepos;
    }

    @Override
    public void save(Weather weather) {
        weatherRepos.save(weather);
    }

    @Override
    public List<Weather> getWeather() {
        return weatherRepos.findAll();
    }
}
