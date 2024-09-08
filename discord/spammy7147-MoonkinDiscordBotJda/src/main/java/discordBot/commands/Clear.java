package discordBot.commands;

import java.util.List;
import java.util.concurrent.TimeUnit;

import discordBot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	
	
	
	
public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		
		if(args[0].equalsIgnoreCase(Bot.prefix + "clear")) {
			if (args.length < 2) {
				//삭제 명령어 사용법
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("삭제할 대화의 갯수를 지정해주세용");
				usage.setDescription("사용설명서: " + Bot.prefix + "clear [섹제할 대화의 갯수 (2~100)]");
				event.getChannel().sendMessage(usage.build()).queue();
				usage.clear();
			}else {
				
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					if(messages.size() < 2) {
						event.getMessage().delete().queueAfter(10, TimeUnit.SECONDS);
						
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 먹을 메세지가 없어요");
						error.setDescription("먹을게 없어용....");
						event.getChannel().sendMessage(error.build()).queue();
						error.clear();
					}else {
						event.getChannel().deleteMessages(messages).queue();
						
						//삭제 완료시 뜨는 메세지
						EmbedBuilder success = new EmbedBuilder();
						success.setColor(0x22ff2a);
						success.setDescription("✅ " + args[1] + "줄 먹기 완료!");
						event.getChannel().sendMessage(success.build()).queue();
						success.clear();
						
					}
					
					
					
					
				}catch (Exception e) {
					e.printStackTrace();
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval") || e.toString().startsWith("java.lang.IllegalArgumentException: Must provide at least 2 or") ) {
						// 2~100개 초과하는 삭제 명령시 오류
						
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 한번에 너무많이..");
						error.setDescription("2 ~ 100줄 까지 입력해주세요 너무 많거나 너무 적으면 못먹어용");
						event.getChannel().sendMessage(error.build()).queue();
						error.clear();
					}else if (e.toString().startsWith("net.dv8tion.jda.api.exceptions.InsufficientPermissionException: Must have MESSAGE_MANAGE in")) {
						
						//2주넘어가는 메세지 삭제불가 
						
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 2주가 넘은 대화");
						error.setDescription("2주 지난 상한 대화는 못먹어용");
						event.getChannel().sendMessage(error.build()).queue();
						error.clear();
						
					}else { //그 외의 오류들
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 잘못된 명령어!");
						error.setDescription("사용설명서: " + Bot.prefix + "clear [삭제할 대화의 갯수 (2~100)]");
						event.getChannel().sendMessage(error.build()).queue();
						error.clear();
					}
					
				}
			}
			
			
		}//clear 명령어 종료
		
		
	}


}
