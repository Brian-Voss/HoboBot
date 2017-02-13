/**
 * 
 */
package com.odin.commands.act.triggers;

import java.util.ArrayList;

import com.odin.commands.Commands;
import com.odin.helpers.FileHelper;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Brian
 *
 */
public class DownloadTriggerFileCommand extends Commands {

	/* (non-Javadoc)
	 * @see com.odin.commands.Commands#called(java.lang.String[], net.dv8tion.jda.core.events.message.MessageReceivedEvent)
	 */
	@Override
	public boolean called(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see com.odin.commands.Commands#help()
	 */
	@Override
	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.odin.commands.Commands#action(java.lang.String[], net.dv8tion.jda.core.events.message.MessageReceivedEvent)
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		FileHelper helper =  new FileHelper();
		ArrayList<String> triggerFiles  = helper.getTriggerFile();
		
		for(String url : triggerFiles)
		{
			event.getTextChannel().sendMessage(url).queue();
		}
		
	}

}
