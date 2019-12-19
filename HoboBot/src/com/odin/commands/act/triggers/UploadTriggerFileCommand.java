/**
 * 
 */
package com.odin.commands.act.triggers;

import java.io.File;
import java.util.List;

import com.odin.commands.Commands;
import com.odin.constants.HelpConstants;
import com.odin.handlers.FileHandler;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Brian
 *
 */
public class UploadTriggerFileCommand extends Commands {

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
		List<Message.Attachment> attachments = event.getMessage().getAttachments();
		if(attachments == null || attachments.size() == 0)
		{
			event.getTextChannel().sendMessage("No attachments found").queue();
			event.getTextChannel().sendMessage(HelpConstants.UPLOAD_TRIGGER).queue();
			return;
		}
		Message.Attachment attachment = attachments.get(0);
		String url = attachment.getUrl();
		fileHandler.writeToTriggerFile(url, "triggers");
		event.getTextChannel().sendMessage("trigger file successfully uploaded").queue();


	}

}
