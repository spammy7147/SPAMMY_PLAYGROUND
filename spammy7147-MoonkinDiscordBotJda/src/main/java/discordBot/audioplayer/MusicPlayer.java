package discordBot.audioplayer;


import java.util.HashMap;
import java.util.Map;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;





public class MusicPlayer extends ListenerAdapter {

  private  static MusicPlayer INSTANCE;
  private final AudioPlayerManager playerManager;
  private final Map<Long, GuildMusicManager> musicManagers;
  private static VoiceChannel vc;

  private MusicPlayer() {
	  
    this.musicManagers = new HashMap<>();
    this.playerManager = new DefaultAudioPlayerManager();
    
    AudioSourceManagers.registerRemoteSources(playerManager);
    AudioSourceManagers.registerLocalSource(playerManager);
  }


  public static synchronized MusicPlayer getInstance() {
	 if (INSTANCE == null) {
		 INSTANCE = new MusicPlayer();
	 }
	 return INSTANCE;
  }
  
  public synchronized GuildMusicManager getGuildAudioPlayer(Guild guild) {
    long guildId = Long.parseLong(guild.getId());
    GuildMusicManager musicManager = musicManagers.get(guildId);

    if (musicManager == null) {
      musicManager = new GuildMusicManager(playerManager);
      musicManagers.put(guildId, musicManager);
    }

    guild.getAudioManager().setSendingHandler(musicManager.getSendHandler());

    return musicManager;
  }

	public void setVoiceChannel(VoiceChannel vc) {
		MusicPlayer.vc = vc;
	}

  public void loadAndPlay(final TextChannel channel, final String trackUrl) {
	
    GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());

    playerManager.loadItemOrdered(musicManager, trackUrl, new AudioLoadResultHandler() {
    	
    	// single music
      @Override
      public void trackLoaded(AudioTrack track) {
    	  System.out.println("trackloaded");
    	  
        channel.sendMessage("Adding to queue " + track.getInfo().title).queue();

        play(channel.getGuild(), musicManager, track);
      }
      
      // playlist music
      @Override
      public void playlistLoaded(AudioPlaylist playlist) {
    	  
    	  
        AudioTrack firstTrack = playlist.getSelectedTrack();

        if (firstTrack == null) {
          firstTrack = playlist.getTracks().get(0);
        }

        channel.sendMessage("Adding to queue " + firstTrack.getInfo().title + " (first track of playlist " + playlist.getName() + ")").queue();

        play(channel.getGuild(), musicManager, firstTrack);
        
      }
      // if can not find music 
      @Override
      public void noMatches() {
    	  System.out.println("no match");
    	  
        channel.sendMessage("Nothing found by " + trackUrl).queue();
      }
      //maybe encoding error or decode 
      @Override
      public void loadFailed(FriendlyException exception) {
    	  System.out.println("Exception");
    	  
        channel.sendMessage("Could not play: " + exception.getMessage()).queue();
      }
    });//loaditemorder method end 
  } // loadandplay 메서드 end

  private void play(Guild guild, GuildMusicManager musicManager, AudioTrack track) {
    connectToFirstVoiceChannel(guild.getAudioManager());
    
    musicManager.scheduler.queue(track);
    
    
  }

  public void skipTrack(TextChannel channel) {
    GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
    musicManager.scheduler.nextTrack();
    
    channel.sendMessage("다음.").queue();
  }

  public static void connectToFirstVoiceChannel(AudioManager audioManager) {
    if (!audioManager.isConnected()) {
      if (vc != null) {
    	  audioManager.openAudioConnection(vc);
      }else {
    	  audioManager.openAudioConnection(audioManager.getGuild().getVoiceChannels().get(1));
    	 ;
      }
        
      
    }
  }
  
  public void disconnectToVoiceChannel (AudioManager audioManager) {
	  if (audioManager.isConnected()) {
		  audioManager.closeAudioConnection();
	  }
  }
  
  
  public void playingCheck(AudioManager audioManager) {
		MusicPlayer mp = MusicPlayer.getInstance();
		GuildMusicManager musicManager = mp.getGuildAudioPlayer(audioManager.getGuild());
		
		if (musicManager.scheduler.onPlaying() == null && musicManager.scheduler.getQueue().size() == 0) {
			
			new java.util.Timer().schedule(
					new java.util.TimerTask() {

						@Override
						public void run() {
							if (musicManager.scheduler.onPlaying() == null && musicManager.scheduler.getQueue().size() == 0) {
								mp.disconnectToVoiceChannel(audioManager);
							}
							
						}
						
					},
						10 * 1000
					
					);

			
			
			}			

		}
  
  
  
}