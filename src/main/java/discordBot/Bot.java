package discordBot;



import javax.security.auth.login.LoginException;
import discordBot.commands.Clear;
import discordBot.audioplayer.MusicPlayer;
import discordBot.commands.AutoDel;
import discordBot.commands.Info;
import discordBot.commands.Mute;
import discordBot.commands.Play;
import discordBot.commands.Set;
import discordBot.events.GuildMemberCNG;
import discordBot.events.GuildMessageReactionAdd;
import discordBot.events.GuildMessageReceived;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Bot {
	//JDA 선언
	public static JDA jda;
	//prefix 선언
	public static String prefix = "-";
	
	public static void main(String[] args) throws LoginException {
		
		//토큰입력
		JDA jda = JDABuilder.createDefault("ODExMDk4NDQwNjExNzkwODc4.YCtQSQ.KudyC9r9uOa_fdQJ20scgowOANs")
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(MusicPlayer.getInstance())
                .build();
		
		//봇 ~하는중이라고뜨는것
		jda.getPresence().setActivity(Activity.watching("나무위키"));
		
		
		//이벤트 리스너 실행!
		
		jda.addEventListener(new AutoDel()); //명령어
		jda.addEventListener(new Info()); //명령어
		jda.addEventListener(new Clear()); //명령어
		jda.addEventListener(new Mute()); //명령어
		jda.addEventListener(new Set()); //명령어
		jda.addEventListener(new Play()); //명령어
		jda.addEventListener(new GuildMemberCNG()); //나갈떄 알림
		jda.addEventListener(new GuildMessageReceived()); //봇 메세지 10개이상 삭제
		jda.addEventListener(new GuildMessageReactionAdd()); // x 누르면 메세지 삭제 + 본인아니면 삭제 NO & 리엑션 제거
		
	}
}
