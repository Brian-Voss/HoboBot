package com.odin.listeners;

import com.odin.main.Main;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

	@Override
	public void onReady(ReadyEvent event) {
		System.out.println("Hobo wanders into your discord");
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getMessage().getContent().startsWith("!~")  && event.getAuthor().getId() != event.getJDA().getSelfUser().getId())
		{
			Main.handleCommand(Main.cmdParser.parse(event.getMessage().getContent().toLowerCase(), event));
		}
	}
}
