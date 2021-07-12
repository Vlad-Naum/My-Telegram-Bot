package com.github.VladNaum.telegram_bot.repo;

import com.github.VladNaum.telegram_bot.weather.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepos extends JpaRepository<Weather, String> {

}
