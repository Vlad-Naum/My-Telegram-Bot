package com.github.VladNaum.MyTelegramBot;

import com.github.VladNaum.MyTelegramBot.command.Command;
import com.github.VladNaum.MyTelegramBot.command.CommandContainer;
import com.github.VladNaum.MyTelegramBot.command.CommandName;
import com.github.VladNaum.MyTelegramBot.command.UnknownCommand;
import com.github.VladNaum.MyTelegramBot.service.SendBotMessageService;
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
    public void shouldGetAllTheExistingCommands(){
        for (CommandName name : CommandName.values()) {
            Command command = commandContainer.retrievCommand(name.getCommandName());
            Assert.assertNotEquals(UnknownCommand.class, command.getClass());
        }
    }

    @Test
    public void shouldReturnUnknownCommand(){
        //given
        String unknown = "/rettt";

        //when
        Command command = commandContainer.retrievCommand(unknown);

        //then
        Assert.assertEquals(UnknownCommand.class, command.getClass());
    }
}
