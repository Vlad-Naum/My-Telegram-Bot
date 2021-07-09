package com.github.VladNaum.telegram_bot.service;

import com.github.VladNaum.telegram_bot.bot.MyTB;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class SendBotMessage implements SendBotMessageService {
    private final MyTB bot;

    @Autowired
    public SendBotMessage(MyTB bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sm = new SendMessage();
        SendPhoto sp = new SendPhoto();
        sp.setPhoto(new InputFile("http://openweathermap.org/img/w/01d.png"));
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
