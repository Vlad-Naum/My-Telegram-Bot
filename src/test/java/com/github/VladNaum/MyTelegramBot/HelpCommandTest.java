package com.github.VladNaum.MyTelegramBot;

import com.github.VladNaum.MyTelegramBot.command.Command;
import com.github.VladNaum.MyTelegramBot.command.HelpCommand;
import org.junit.jupiter.api.DisplayName;

import static com.github.VladNaum.MyTelegramBot.command.CommandName.HELP;
import static com.github.VladNaum.MyTelegramBot.command.HelpCommand.HELP_MESS;

@DisplayName("Unit-level testing for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESS;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
