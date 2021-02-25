package discordBot.commands;

import discordBot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Mute extends ListenerAdapter{

	

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		


		//unmute
		if (args[0].equalsIgnoreCase(Bot.prefix + "아봉")) {
					
					if(args.length > 1 && args.length < 3) {
						//언급된 맴버 가져오기
						Member member = event.getGuild().retrieveMemberById(args[1].replace("<@", "").replace(">","").replace("!","")).complete();
						//아봉중 역활 가져오기
						Role role = event.getGuild().getRoleById("811503736581128233");
						//아봉중 이라면!
						if(member.getRoles().contains(role)) {
							// unmute
							event.getChannel().sendMessage(args[1]+" 아봉 끝").queue();
							event.getGuild().removeRoleFromMember(member, role).complete();
						}
					}
		}else if (args[0].equalsIgnoreCase(Bot.prefix + "아봉")) {
			
			if(args.length > 1 && args.length < 3) {
				//언급된 맴버 가져오기
				Member member = event.getGuild().retrieveMemberById(args[1].replace("<@", "").replace(">","").replace("!","")).complete();
				//아봉중 역활 가져오기
				Role mute = event.getGuild().getRoles().get(event.getGuild().getRoles().size()-2);
				//아봉중이 아니라면!
				if(!member.getRoles().contains(mute)) {
					
					//Mute user
					event.getChannel().sendMessage(args[1]+" 아봉시작").queue();
					event.getGuild().addRoleToMember(member, mute).complete();
					
				}
				
			}else if (args.length == 3){ //아봉중 타이머 설정
				//언급된 맵버 가져오기
				Member member = event.getGuild().retrieveMemberById(args[1].replace("<@", "").replace(">","").replace("!","")).complete();
				//아봉중 역활 가져오기
				Role mute = event.getGuild().getRoles().get(event.getGuild().getRoles().size()-2);
				
				//mute 명령실행
				event.getChannel().sendMessage(args[1]+" "+args[2]+"초 아봉").queue();
				event.getGuild().addRoleToMember(member, mute).complete();
				
				//타이머 설정 후 자동으로 unmute 실행
				new java.util.Timer().schedule(
						new java.util.TimerTask() {

							@Override
							public void run() {
								event.getChannel().sendMessage(args[1]+"아봉 해제").queue();
								event.getGuild().removeRoleFromMember(member, mute).complete();
								
							}
							
						},
						Integer.parseInt(args[2]) * 1000
						
						);
				
			}else if(args.length == 1) {
				
				EmbedBuilder mute = new EmbedBuilder();
				mute.setTitle("mute");
				mute.setDescription(

						" -mute [@아봉대상]\n"+
						"-unmute [@아봉대상]\n"+
						"-mute [@아봉대상] [타이머]\n"
						);
				event.getChannel().sendMessage(mute.build()).queue();
				mute.clear();
				
				
			}
			
		}
	}
}
