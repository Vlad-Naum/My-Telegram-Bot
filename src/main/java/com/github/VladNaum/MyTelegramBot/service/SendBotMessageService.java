package com.github.VladNaum.MyTelegramBot.service;

   /*
   Сервис для отправки сообщений в телеграмм.
    */
public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
