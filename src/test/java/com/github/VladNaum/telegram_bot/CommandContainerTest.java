package com.github.VladNaum.telegram_bot;

import com.github.VladNaum.telegram_bot.command.Command;
import com.github.VladNaum.telegram_bot.command.CommandContainer;
import com.github.VladNaum.telegram_bot.command.CommandName;
import com.github.VladNaum.telegram_bot.command.StartCommand;
import com.github.VladNaum.telegram_bot.service.SendBotMessageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

@DisplayName("Unit-level testing for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetStartCommand(){
        Command command = commandContainer.retrievCommand(CommandName.START.getCommandName());
        Assert.assertEquals(StartCommand.class, command.getClass());
    }

    @Test
    public void shouldGetStopCommand(){
        Command command = commandContainer.retrievCommand(CommandName.STOP.getCommandName());
        Assert.assertEquals(StartCommand.class, command.getClass());
    }

    @Test
    public void shouldGetHelpCommand(){
        Command command = commandContainer.retrievCommand(CommandName.HELP.getCommandName());
        Assert.assertEquals(StartCommand.class, command.getClass());
    }

}
