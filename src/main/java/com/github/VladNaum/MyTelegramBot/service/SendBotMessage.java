package com.github.VladNaum.MyTelegramBot.service;

import com.github.VladNaum.MyTelegramBot.bot.MyTB;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendBotMessage implements SendBotMessageService {
    private final MyTB bot;

    @Autowired
    public SendBotMessage(MyTB bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sm = new SendMessage();
        sm.setText(message);
        sm.setChatId(chatId);
        sm.enableHtml(true);

        try {
            bot.execute(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
