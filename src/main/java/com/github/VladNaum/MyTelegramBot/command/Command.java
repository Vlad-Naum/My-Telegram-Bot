package com.github.VladNaum.MyTelegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

   /*
    Интерфейс реализующий основные комманды.
    */

public interface Command {

    void execute(Update update);
}
