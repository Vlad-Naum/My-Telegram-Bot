package com.github.VladNaum.MyTelegramBot;

import com.github.VladNaum.MyTelegramBot.command.Command;
import com.github.VladNaum.MyTelegramBot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.VladNaum.MyTelegramBot.command.CommandName.NO;
import static com.github.VladNaum.MyTelegramBot.command.NoCommand.NO_MESS;

@DisplayName("Unit-level testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESS;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
