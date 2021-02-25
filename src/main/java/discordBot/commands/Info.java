package discordBot.commands;

import discordBot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Info extends ListenerAdapter{

	
	
	
public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		//봇 정보 보기 명령어
		if(args[0].equalsIgnoreCase(Bot.prefix + "info")) {
			
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("뿌엉이 정보 ❤"); 
			info.setDescription("봇 명령어 주문 :   -    \n\n"
					+ "명령어 리스트 : \n"
					+ "▪ clear \n"
					+ "▪ 아봉 \n"
					+ "▪ set \n");
			info.setColor(0xff7c0a); //드루이드 오피셜 색깔
			info.setFooter("Created by Spammy", event.getJDA().retrieveUserById("240119065174081536").complete().getAvatarUrl());
			
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		} 
		
	}
}
