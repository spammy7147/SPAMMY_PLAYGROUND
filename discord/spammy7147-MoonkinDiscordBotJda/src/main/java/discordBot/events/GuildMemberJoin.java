package discordBot.events;

import java.util.Random;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter{
	
	String[] messages = {
			"[member]님 어서와 여긴 처음이지?",
			"[member]님 라면먹고갈래?",
			"[member]님 내가좋아? 아니면 내가좋아?",
			"[member]님 너 내꺼할래?",
			"[member]님 너 내꺼",
			"[member]님 가즈아~",
			"[member]님 주식은... ",
			"[member]님 비트코인은... "
	};
	


	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		
		System.out.println("메서드 시작");
		
		Random rand = new Random();
		int number = rand.nextInt(messages.length);
		
		
		EmbedBuilder join = new EmbedBuilder();
		join.setTitle("welcome");
		join.setColor(0x66d8ff);
		join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
		
		
		event.getGuild().getTextChannelById("811097855291949069").sendMessage(join.build()).queue();
		event.getGuild().getTextChannelById("811097855291949069").sendMessage("어서오고").queue();
		//add role
		event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("811497338194493442")).complete();
		
	} //onGuildMemberJoin 메서드 종료
	
	
	
	
	
	
	
	
	
} //class end
