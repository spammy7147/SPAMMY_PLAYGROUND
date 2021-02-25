package discordBot.commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import discordBot.Bot;
import discordBot.embedblueprint.EmbedBlueprint;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Set extends ListenerAdapter{

	
	
	List<Message> messages = new ArrayList<>();
	static List<EmbedBlueprint> embeds = new ArrayList<>();
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		//set description
		if(args[0].equals(Bot.prefix + "set")) {
			//띄어쓰기 통합
			boolean flag =false;
			boolean error = false;
			String description = "";	
			if(args.length > 3) {
				for(int i = 2; i<args.length;i++) {
					
					description += args[i]+" ";
		
				}
			}else if (args.length == 3) {
				description = args[2];
			
			}else if (args.length == 2) {
				//set 설명추가 필요
				error = true;
			}else {
				//set 명령어 설명
				error = true;
			}
			
			if (error == false) {
				//설정된 description 이 있을떄	
				if(embeds.size() != 0) {
					
					//중복확인 for문
					for (EmbedBlueprint eb : embeds) { 
						
						//중복확인 if문
						if(args[1].equals(eb.getTitle())){ 
							flag = true;
							//System.out.println("중복있을떄");
							eb.setDescription(description);
							eb.setUser(event.getAuthor().getName());
							
							EmbedBuilder setEmbed = new EmbedBuilder();
							setEmbed.setTitle(eb.getTitle());
							setEmbed.setDescription(eb.getDescription());
							setEmbed.setColor(eb.getColor());
							setEmbed.setFooter("by " + eb.getUser());
							event.getChannel().sendTyping().queue();
							event.getChannel().sendMessage(setEmbed.build()).queue();
							break;
						}
					}
				}
					
					//중복없을떄
					if (flag == false) {
					
					
						
						Random c =  new Random();
						Color color = new Color(c.nextInt(255), c.nextInt(255), c.nextInt(255));
						
						EmbedBlueprint set = new EmbedBlueprint(); 
						EmbedBuilder setEmbed = new EmbedBuilder();
						set.setTitle(args[1]);
						set.setDescription(description);
						set.setUser(event.getAuthor().getName());
						set.setColor(color);
						setEmbed.setTitle(args[1]);
						setEmbed.setDescription(description);
						setEmbed.setColor(color);
						setEmbed.setFooter("by " + event.getAuthor().getName());
				
						embeds.add(set);
						
						event.getChannel().sendTyping().queue();
						event.getChannel().sendMessage(setEmbed.build()).queue();
						
					
				
					}
				

				}
		
			}
			
		
		///// 부르기
		if(args[0].startsWith("-")){
			for(EmbedBlueprint eb : embeds) {
				if((Bot.prefix + eb.getTitle()).equals(args[0])){
					
					EmbedBuilder setEmbed = new EmbedBuilder();
					setEmbed.setTitle(eb.getTitle());
					setEmbed.setDescription(eb.getDescription());
					setEmbed.setColor(eb.getColor());
					setEmbed.setFooter("created by " + eb.getUser());
					event.getChannel().sendTyping().queue();
					event.getChannel().sendMessage(setEmbed.build()).queue();
				}
			}
		}
		
	}
		
}
