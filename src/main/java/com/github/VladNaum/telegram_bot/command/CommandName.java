package com.github.VladNaum.telegram_bot.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
