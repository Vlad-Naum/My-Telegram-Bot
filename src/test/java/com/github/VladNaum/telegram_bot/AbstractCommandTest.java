package com.github.VladNaum.telegram_bot;

import com.github.VladNaum.telegram_bot.bot.MyTB;
import com.github.VladNaum.telegram_bot.command.Command;
import com.github.VladNaum.telegram_bot.service.SendBotMessage;
import com.github.VladNaum.telegram_bot.service.SendBotMessageService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {
    protected MyTB bot = Mockito.mock(MyTB.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessage(bot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 8786788231L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Assert.assertEquals(message.getChatId(), chatId);
        Assert.assertEquals(message.getText(), getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(bot).execute(sendMessage);
    }
}
