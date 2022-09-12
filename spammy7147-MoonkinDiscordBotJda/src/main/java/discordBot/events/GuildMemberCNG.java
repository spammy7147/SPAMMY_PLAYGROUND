package discordBot.events;



import java.util.Random;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberCNG extends ListenerAdapter{
	
	
	
	String[] messagesJoin = {
			"어서오세요~ [member]님 뿌엉이가 반겨요! \n 뿌엉이의 명령어를 보려면 '-info'를 입력하세요! \n 즐거운 게임 라이프 즐겨용❤"
	
	};
	String[] messagesLeave = {
			"[member]님이 나갔어용ㅠㅠ ",
			
	};
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		
		Role guest = event.getGuild().getRoles().get(event.getGuild().getRoles().size()-3);
		Role mute = event.getGuild().getRoles().get(event.getGuild().getRoles().size()-2);
		
		
		//add role
		event.getGuild().addRoleToMember(event.getMember(), guest).queue();
		Random rand = new Random();
		int number = rand.nextInt(messagesJoin.length);
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0xff7c0a);
		join.setDescription(messagesJoin[number].replace("[member]", event.getMember().getAsMention()));
		

		new java.util.Timer().schedule(
				new java.util.TimerTask() {

					@Override
					public void run() {
						event.getGuild().getTextChannels().get(0).sendMessage(join.build()).queue();
						}
					
				},
				5 * 1000
				
				
				
				);
		
		
	}
	

	
	@Override
	public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
		

		
		Random rand = new Random();
		int number = rand.nextInt(messagesLeave.length);
		EmbedBuilder leave = new EmbedBuilder();
		leave.setColor(0xff7c0a);
		leave.setDescription(messagesLeave[number].replace("[member]", event.getUser().getName()));
		event.getGuild().getTextChannelById("812166421525561344").sendMessage(leave.build()).queue();
	}
	

}
