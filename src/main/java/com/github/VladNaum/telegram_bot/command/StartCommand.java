package com.github.VladNaum.telegram_bot.command;

import com.github.VladNaum.telegram_bot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESS = "Привет. Я телеграмм-бот. " +
            "Пока, что мой функционал оганичен, но все впереди.";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESS);
    }
}
