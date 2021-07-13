package com.github.VladNaum.telegram_bot.command;

import com.github.VladNaum.telegram_bot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.VladNaum.telegram_bot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;

    public CommandContainer(SendBotMessageService sendBotMessageService){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .build();
    }

    public Command retrievCommand (String commandIdentifier){
        return commandMap.get(commandIdentifier);
    }
}
