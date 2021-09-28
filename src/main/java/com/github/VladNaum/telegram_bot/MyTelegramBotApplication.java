package com.github.VladNaum.telegram_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTelegramBotApplication.class, args);
	}

}
