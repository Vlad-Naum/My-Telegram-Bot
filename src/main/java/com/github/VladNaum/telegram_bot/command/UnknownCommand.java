package com.github.VladNaum.telegram_bot.command;

import com.github.VladNaum.telegram_bot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String UNKNOWN_MESS = "Не понимаю вас. Напишите /help " +
            "чтобы увидеть список всех доступных команд.";

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESS);
    }
}
