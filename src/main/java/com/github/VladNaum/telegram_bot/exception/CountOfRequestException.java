package com.github.VladNaum.telegram_bot.exception;

public class CountOfRequestException extends Exception {

    public CountOfRequestException() {
        super("Превышен лимит запросов для данного города. Попробуйте позже.");
    }
}
