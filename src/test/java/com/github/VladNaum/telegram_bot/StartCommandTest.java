package com.github.VladNaum.telegram_bot;

import com.github.VladNaum.telegram_bot.command.Command;
import com.github.VladNaum.telegram_bot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.VladNaum.telegram_bot.command.CommandName.START;
import static com.github.VladNaum.telegram_bot.command.StartCommand.START_MESS;

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
