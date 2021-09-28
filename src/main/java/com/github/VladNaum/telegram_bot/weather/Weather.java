package com.github.VladNaum.telegram_bot.weather;

<<<<<<< HEAD
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
=======
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

>>>>>>> heroku

@Data
@Entity
@Table(name = "Weather")
public class Weather {
<<<<<<< HEAD
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
=======
    private final String city;
    private final String description;
    private final int temperature;
    private final int windSpeed;
    private Instant date;
>>>>>>> heroku

    public Weather(String city, String description, int temperature, int windSpeed) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
<<<<<<< HEAD
        this.date = formater.format(date);
        this.time = formater2.format(date);
    }

    public Weather() {
=======
    }

    public void setDate(Instant date) {
        this.date = date;
>>>>>>> heroku
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return city + "\n" + date + "\n"
                + time + "\nТемпература: " + temperature
=======
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withZone(ZoneId.of("Europe/Moscow"));
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.of("Europe/Moscow"));
        return city + "\n" + formatter.format(date) + "\n"
                + formatter2.format(date) + "\nТемпература: " + temperature
>>>>>>> heroku
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
