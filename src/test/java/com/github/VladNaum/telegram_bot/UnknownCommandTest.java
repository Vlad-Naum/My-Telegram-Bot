package com.github.VladNaum.telegram_bot;

import com.github.VladNaum.telegram_bot.command.Command;
import com.github.VladNaum.telegram_bot.command.UnknownCommand;

import static com.github.VladNaum.telegram_bot.command.UnknownCommand.UNKNOWN_MESS;

public class UnknownCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return "/erterg";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESS;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
