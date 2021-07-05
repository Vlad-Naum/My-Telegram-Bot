package com.github.VladNaum.telegram_bot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

   /*
    Интерфейс реализующий основные комманды.
    */

public interface Command {

    void execute(Update update);
}
