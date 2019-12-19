/**
 * 
 */
package com.odin.commands.mentor;

import com.odin.commands.Commands;
import com.odin.constants.HelpConstants;
import com.odin.handlers.FileHandler;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Brian
 *
 */
public class CreateMentorCommand extends Commands {

	/* (non-Javadoc)
	 * @see com.odin.commands.Commands#called(java.lang.String[], net.dv8tion.jda.core.events.message.MessageReceivedEvent)
	 */
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.odin.commands.Commands#help()
	 */
	@Override
	public String help() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.odin.commands.Commands#action(java.lang.String[], net.dv8tion.jda.core.events.message.MessageReceivedEvent)
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		FileHandler fileHandler = new FileHandler();
		if(args.length != 4)
		{
			event.getTextChannel().sendMessage("Not all parameters were entered").queue();
			event.getTextChannel().sendMessage(HelpConstants.CREATE_MENTOR).queue();
			return;
		}
		
		fileHandler.writeToMentorFile(args[0], args[1], args[2], args[3]);
		event.getTextChannel().sendMessage("Mentor added").queue();
	}

}
