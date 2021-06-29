package com.github.VladNaum.MyTelegramBot;

import com.github.VladNaum.MyTelegramBot.command.Command;
import com.github.VladNaum.MyTelegramBot.command.UnknownCommand;

import static com.github.VladNaum.MyTelegramBot.command.UnknownCommand.UNKNOWN_MESS;

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
