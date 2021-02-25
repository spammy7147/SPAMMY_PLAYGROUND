package discordBot.events;


import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter{
	
	List<Message> messages = new ArrayList<>();
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		
		
		if(event.getMessage().getAuthor().equals(event.getJDA().retrieveUserById("811098440611790878").complete())){
			
			
			
			Message ms = event.getMessage();
			messages.add(ms);
			
			
			if (messages.size() == 10) {
				
				new java.util.Timer().schedule(
						new java.util.TimerTask() {

							@Override
							public void run() {
								event.getChannel().deleteMessages(messages).queue();	
							}
							
						},
						60 * 1000
						
						);
				
			}
		}
		
		
	}

	
}
