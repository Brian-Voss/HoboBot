/**
 * 
 */
package com.odin.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Brian
 *
 */
public abstract class Commands {
	
	public abstract boolean called(String args[], MessageReceivedEvent event);
	public abstract String help();
	public abstract void action(String args[], MessageReceivedEvent event);
	
	public boolean executed(boolean success, MessageReceivedEvent event)
	{
		return true;
	}

}
