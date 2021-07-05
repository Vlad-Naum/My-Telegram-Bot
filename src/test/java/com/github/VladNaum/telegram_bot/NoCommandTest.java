package com.github.VladNaum.telegram_bot;

import com.github.VladNaum.telegram_bot.command.Command;
import com.github.VladNaum.telegram_bot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.VladNaum.telegram_bot.command.CommandName.NO;
import static com.github.VladNaum.telegram_bot.command.NoCommand.NO_MESS;

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
