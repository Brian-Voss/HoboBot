/**
 * 
 */
package com.odin.commands.parser;

import java.util.ArrayList;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * @author Brian
 *
 */
public class CommandParser {

	 public CommandContainer parse(String raw, MessageReceivedEvent event)
	 {
		 ArrayList<String> split = new ArrayList<String>();
		 String behead  = raw.replace('#', ' ');
		 String[] splitBehead = behead.split(" ");
		 for(String beheadString : splitBehead)
		 {
			 split.add(beheadString);
		 }
		 
		 String invoke = split.get(0);
		 String[] args = new String[split.size() - 1];
		 split.subList(1, split.size()).toArray(args);
		 
		 return new CommandContainer(raw, behead, splitBehead, invoke, args, event);
	 }
	 
	 public class CommandContainer {

			private final String raw;
			private final String beheaded;
			private final String[] splitBeheaded;
			private final String invoke;
			private final String[] args;
			public final MessageReceivedEvent event;
			
			public CommandContainer(String raw, String behead, String[] splitBehead, String invoke, String[] args, MessageReceivedEvent event)
			{
				this.raw = raw;
				this.beheaded = behead;
				this.splitBeheaded = splitBehead;
				this.invoke = invoke;
				this.args = args;
				this.event = event;
			}

			public String getRaw() {
				return raw;
			}

			public String getBeheaded() {
				return beheaded;
			}

			public String[] getSplitBeheaded() {
				return splitBeheaded;
			}

			public String getInvoke() {
				return invoke;
			}

			public String[] getArgs() {
				return args;
			}

			public MessageReceivedEvent getEvent() {
				return event;
			}
			
}
}

