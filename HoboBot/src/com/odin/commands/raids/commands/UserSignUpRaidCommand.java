package com.odin.commands.raids.commands;

import com.odin.commands.Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class UserSignUpRaidCommand extends Commands {

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
