package com.odin.commands.user.info;

import com.odin.commands.Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class EnterUserInfoCommand extends Commands {

	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return false;
	}

	@Override
	public String help() {
		return null;
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

	}

}
