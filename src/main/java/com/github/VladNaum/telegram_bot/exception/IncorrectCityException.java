package com.github.VladNaum.telegram_bot.exception;

public class IncorrectCityException extends Exception {

    public IncorrectCityException(String city) {
        super(String.format("Неверно введен город - %s. Повторите попытку.", city));
    }
}
