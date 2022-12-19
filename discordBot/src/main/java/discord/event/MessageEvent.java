package discord.event;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class MessageEvent extends ListenerAdapter {




    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("onReadyEvent");

    }

    @Override
    public void onMessageUpdate(MessageUpdateEvent event) {
        System.out.println("MessageEvent.onMessageUpdate");
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        event.getGuild().getDefaultChannel().asTextChannel().sendMessage("안녕 난 뿌엉이야").queue();
        System.out.println(event.getMember().getGuild().getDefaultChannel().asTextChannel().getLatestMessageId());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("event Message");
        System.out.println(event.getMessage());
    }
}
