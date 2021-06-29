package com.github.VladNaum.MyTelegramBot;

import com.github.VladNaum.MyTelegramBot.command.Command;
import com.github.VladNaum.MyTelegramBot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.VladNaum.MyTelegramBot.command.CommandName.START;
import static com.github.VladNaum.MyTelegramBot.command.StartCommand.START_MESS;

@DisplayName("Unit-level testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESS;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
