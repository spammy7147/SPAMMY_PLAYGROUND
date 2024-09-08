package discordBot.commands;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;

import discordBot.Bot;
import discordBot.audioplayer.GuildMusicManager;
import discordBot.audioplayer.MusicPlayer;
import discordBot.audioplayer.Youtube;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class Play extends ListenerAdapter{
	
	
	
	static VoiceChannel whereAuthorAt;
 
	@Override
  
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
    
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
	

		
		
			
			
			
			
		if(args[0].equals(Bot.prefix + "노래")) {
			
			boolean error = false;
			String search = "";	
			if(args.length > 2) {
				for(int i = 1; i<args.length;i++) {
					
					search += args[i]+" ";
		
				}
			}else if (args.length == 2) {
				search = args[1];
				
			}else {
				//play 명령어 설명
				
					error = true;
					EmbedBuilder info = new EmbedBuilder();
					info.setTitle("노래 명령어"); 
					info.setDescription("▪ -노래 [URL] \n"
							+ "▪ -노래 [제목(유튜브검색)] \n"
							+ "▪ -다음 \n"
							+ "▪ -재생목록 \n"
							
							);
					info.setColor(0xff7c0a); //드루이드 오피셜 색깔
					event.getChannel().sendMessage(info.build()).queue();
					
				}
				
			
			// 명령어 뒤에 검색 or url 
			if(error == false) {
		
			List<VoiceChannel> voiceChannel = event.getGuild().getVoiceChannels();
			for (VoiceChannel vc : voiceChannel) {
				for (Member mb : vc.getMembers()) {
					if(mb.getId().equals(event.getAuthor().getId())){
						whereAuthorAt = vc;
					}
				}
			}
			
			MusicPlayer mp = MusicPlayer.getInstance();
			Youtube youtube = Youtube.getInstance();
			String urlStart = "https://www.youtube.com/watch?v=";
			String urlEnd = "";
			mp.setVoiceChannel(whereAuthorAt);


			List<JSONObject> musicInfo = null;

			if (error == false && !search.startsWith("https://")) {

				try {
		
					musicInfo = youtube.searchForVideo(search);
		
					urlEnd = musicInfo.get(0).getJSONObject("id").getString("videoId");

					System.out.println(musicInfo.get(0).getJSONObject("id").getString("videoId"));
					System.out.println(musicInfo.get(0).getJSONObject("snippet").getString("title"));

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		
			String musicUrl = urlStart + urlEnd;

			if (search.startsWith("https://")) {
		
					mp.loadAndPlay(event.getChannel(), search);

				}else {
		
					mp.loadAndPlay(event.getChannel(), musicUrl);

				}
	 
			}
			} //노래 end
			
		if(args[0].equals(Bot.prefix+"다음")) {
			MusicPlayer mp = MusicPlayer.getInstance();
			
			mp.skipTrack(event.getChannel());
		
		} // 다음 end 
		if ((Bot.prefix+"재생목록").equals(args[0])) {
			MusicPlayer mp = MusicPlayer.getInstance();
			
			System.out.println("playlist");
		
			GuildMusicManager guildMuicManager = mp.getGuildAudioPlayer(event.getGuild());
		
			event.getChannel().sendMessage("재생중 : "+guildMuicManager.scheduler.onPlaying().getInfo().title).queue();
		
				if (guildMuicManager.scheduler.getQueue().size() != 0) {
		
					event.getChannel().sendMessage("== 재생 목록 ==").queue();
					
					for(AudioTrack at : guildMuicManager.scheduler.getQueue()) {
				    	
						System.out.println(at.getInfo().title);
		    	
		    		event.getChannel().sendMessage(at.getInfo().title).queue();
					}
				}
			if((Bot.prefix + "나가").equals(args[0])) {
				mp.disconnectToVoiceChannel(event.getGuild().getAudioManager());
			}
			} //재생 목록 end 
		
		



		super.onGuildMessageReceived(event);
	} // onguildmessage 
	
	
	
	

	

}//class
