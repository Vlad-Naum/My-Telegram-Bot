package com.github.VladNaum.telegram_bot.weather;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Table(name = "Weather")
public class Weather {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Date")
    private String date;

    @Column(name = "City")
    private String city;

    @Column(name = "Time")
    private String time;

    @Column(name = "Temp")
    private int temperature;

    @Column(name = "WindSpeed")
    private int windSpeed;

    @Column(name = "Description")
    private String description;

    public static SimpleDateFormat formater = new SimpleDateFormat("dd.MM.YYYY");
    public static SimpleDateFormat formater2 = new SimpleDateFormat("HH:mm:ss");

    public Weather(String city, String description, int temperature, int windSpeed, Date date) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.date = formater.format(date);
        this.time = formater2.format(date);
    }

    public Weather() {
    }

    @Override
    public String toString() {
        return city + "\n" + date + "\n"
                + time + "\nТемпература: " + temperature
                + " C\nСкорость ветра: " + windSpeed + " м/с" + "\n"
                + description.substring(0,1).toUpperCase() + description.substring(1);

    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public String getTime() {
        return time;
    }
}
