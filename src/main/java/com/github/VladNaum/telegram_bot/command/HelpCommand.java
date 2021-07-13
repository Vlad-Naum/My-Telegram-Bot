package com.github.VladNaum.telegram_bot.command;

import com.github.VladNaum.telegram_bot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.VladNaum.telegram_bot.command.CommandName.*;

public class HelpCommand implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String HELP_MESS = String.format("✨<b>Дотупные команды</b>✨\n\n"
                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n"
                    + "\nЧтобы получить погоду, напишите название города на русском языке."
                    + "Запрашивать погоду в одном городе можно не чаще одного раза в час.",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESS);
    }
}
