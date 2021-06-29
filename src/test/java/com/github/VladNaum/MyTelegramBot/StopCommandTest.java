package com.github.VladNaum.MyTelegramBot;

import com.github.VladNaum.MyTelegramBot.command.Command;
import com.github.VladNaum.MyTelegramBot.command.StopCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.VladNaum.MyTelegramBot.command.CommandName.STOP;
import static com.github.VladNaum.MyTelegramBot.command.StopCommand.STOP_MESS;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESS;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }
}
