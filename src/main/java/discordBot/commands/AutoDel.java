package discordBot.commands;




import java.util.concurrent.TimeUnit;
import discordBot.Bot;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AutoDel extends ListenerAdapter{
	
	

	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		try {
			if(args[0].startsWith(Bot.prefix)) {
				System.out.println("- ");
				System.out.println(args.length);
			
				if (!(args[0].equals(Bot.prefix+"clear") && args.length == 2)) {
					event.getMessage().delete().queueAfter(10, TimeUnit.SECONDS);
				}
			}
			
					

				
			
			
				if(event.getAuthor().isBot()) {
					if (!event.getMessage().getChannel().getId().equals(event.getGuild().getTextChannels().get(0).getId())) {
						event.getMessage().delete().queueAfter(10, TimeUnit.SECONDS);
					}
				}
			
			
			
				
		} catch (Exception e) {
		
		}

		
		
	}//event Listener 

	
	
	
}//class end 
