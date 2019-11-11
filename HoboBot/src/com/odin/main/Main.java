/**
 * 
 */
package com.odin.main;

import java.util.HashMap;

import javax.security.auth.login.LoginException;

import com.odin.commands.Commands;
import com.odin.commands.HelpCommand;
import com.odin.commands.PingCommand;
import com.odin.commands.act.triggers.DownloadTriggerFileCommand;
import com.odin.commands.act.triggers.UploadTriggerFileCommand;
import com.odin.commands.mentor.CreateMentorCommand;
import com.odin.commands.mentor.DeleteMentorCommand;
import com.odin.commands.mentor.ListMentorsCommand;
import com.odin.commands.parser.CommandParser;
import com.odin.constants.BotConstants;
import com.odin.constants.CommandConstants;
import com.odin.helpers.FileHelper;
import com.odin.listeners.ReadyListener;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

/**
 * @author Brian
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static HashMap<String,Commands> commands = new HashMap<String,Commands>();
	public static CommandParser cmdParser = new CommandParser();
	public static JDA jda;
	
	public static void main(String[] args) {

		FileHelper fileHelper = new FileHelper();
		JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT);
		jdaBuilder.setToken(BotConstants.BOT_TOKEN);
		jdaBuilder.setAudioEnabled(false);
		jdaBuilder.setAutoReconnect(true);
		
		jdaBuilder.addListener(new ReadyListener());
		
		commands.put(CommandConstants.PING_COMMAND,new PingCommand());
		commands.put(CommandConstants.HELP_COMMAND,new HelpCommand());
		commands.put(CommandConstants.UPLOAD_FILE_COMMAND,new UploadTriggerFileCommand());
		commands.put(CommandConstants.DOWNLOAD_FILE_COMMAND,new DownloadTriggerFileCommand());
		commands.put(CommandConstants.LIST_MENTOR_COMMAND,new ListMentorsCommand());
		commands.put(CommandConstants.CREATE_MENTOR_COMMAND,new CreateMentorCommand());
		commands.put(CommandConstants.DELETE_MENTOR_COMMAND,new DeleteMentorCommand());
		try {
			 jda = jdaBuilder.buildBlocking();
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RateLimitedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void handleCommand(CommandParser.CommandContainer cmd)
	{
		if(commands.containsKey(cmd.getInvoke()))
		{
			boolean safe = commands.get(cmd.getInvoke()).called(cmd.getArgs(), cmd.getEvent());
			if(safe)
			{
				commands.get(cmd.getInvoke()).action(cmd.getArgs(), cmd.getEvent());
				commands.get(cmd.getInvoke()).executed(safe, cmd.getEvent());
			}
			else
			{
				commands.get(cmd.getInvoke()).executed(safe, cmd.getEvent());
			}
			
		}
	}
}
