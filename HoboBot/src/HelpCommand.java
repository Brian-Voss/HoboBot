import java.util.ArrayList;

import com.odin.commands.Commands;
import com.odin.constants.HelpConstants;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * 
 */

/**
 * @author Brian
 *
 */
public class HelpCommand extends Commands {

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

		ArrayList<String> help = new  ArrayList<String>();
		
		help.add(HelpConstants.PING_COMMMAND);
		help.add(HelpConstants.DOWNLOAD_TRIGGER);
		help.add(HelpConstants.UPLOAD_TRIGGER);
		help.add(HelpConstants.CREATE_MENTOR);
		help.add(HelpConstants.DELETE_MENTOR);
		help.add(HelpConstants.LIST_MENTOR);
		help.add(HelpConstants.ADD_RAID_MGR);
		help.add(HelpConstants.ADD_RAID_TIME);
		help.add(HelpConstants.CHANGE_RAID_INFO);
		help.add(HelpConstants.DELETE_RAID_ADMIN);
		help.add(HelpConstants.LIST_RAID_TIMES);
		help.add(HelpConstants.RAID_MGR);
		help.add(HelpConstants.USER_RAID_SIGNUP);
		help.add(HelpConstants.WHOIS_RAID_ADMIN);
		help.add(HelpConstants.ADD_ROTATION);
		help.add(HelpConstants.DELETE_ROTATION);
		help.add(HelpConstants.GET_ROTATION);
		help.add(HelpConstants.CHANGE_USER_INFO);
		help.add(HelpConstants.DELETE_USER_INFO);
		help.add(HelpConstants.ENTER_USER_INFO);
		help.add(HelpConstants.HELP);
		
		String commands = "";
		for(String command : help)
		{
			commands.concat("/n" + command);
		}
		
		try {
			event.getTextChannel().sendMessage(commands).queue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
