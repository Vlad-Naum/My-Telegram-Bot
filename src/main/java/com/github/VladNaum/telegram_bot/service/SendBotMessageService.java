package com.github.VladNaum.telegram_bot.service;

   /*
   Сервис для отправки сообщений в телеграмм.
    */
public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
