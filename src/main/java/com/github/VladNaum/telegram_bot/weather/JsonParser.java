package com.github.VladNaum.telegram_bot.weather;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonParser {
    private static final String apiKey = "04bf680b29855a1596ff020020b6af89";

    public static Weather parser(String city){
        String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&lang=ru",
                city.toLowerCase(), apiKey);
        try(InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))){
            String jsonText = readAll(rd);
            JsonObject json = new com.google.gson.JsonParser().parse(jsonText).getAsJsonObject();

            JsonObject wind = (JsonObject) json.get("wind");
            JsonObject main = (JsonObject) json.get("main");
            JsonArray weather = (JsonArray) json.get("weather");

            int temperature = main.get("temp").getAsInt()-273;
            int windSpeed = wind.get("speed").getAsInt();
            String cityName = json.get("name").getAsString();
            String description = weather.get(0).getAsJsonObject().get("description").getAsString();

            SimpleDateFormat formater = new SimpleDateFormat("dd.MM.YYYY");
            Date date = new Date();

            return new Weather(cityName, description,temperature, windSpeed, date);

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
