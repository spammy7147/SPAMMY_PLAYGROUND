package discord.event;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageBulkDeleteEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import net.dv8tion.jda.api.requests.restaction.RoleAction;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.internal.requests.restaction.MessageCreateActionImpl;
import net.dv8tion.jda.internal.requests.restaction.RoleActionImpl;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

@Slf4j
public class MessageEvent extends ListenerAdapter {

    static List<String> gamerList = new ArrayList<>();

    /**
     * @EmbedBuilder Example
     *
     * EmbedBuilder hello = new EmbedBuilder();
     * hello.setTitle("welcome");
     * hello.setColor(0x66d8ff);
     * hello.setDescription("이게뭘까");
     *
     * event.getChannel().sendMessageEmbeds(hello.build()).queue();
     */


    @Override
    public void onReady(ReadyEvent event) {
        log.info("On Ready : {}", event);
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        event.deferEdit().queue();
        log.info("button ID = {}",event.getButton().getId());

        switch (event.getButton().getId()){
            case "start":
                event.getMember().getUser().openPrivateChannel().flatMap( channel -> channel.sendMessage("당신은 게임에 참여하셨습니다.")).queue();
                log.info("nickName = {}", event.getMember().getEffectiveName());
                gamerList.add(event.getMember().getEffectiveName());
                break;
            case "cancel":
                event.getMember().getUser().openPrivateChannel().flatMap( channel -> channel.sendMessage("게임 참여를 취소했습니다.")).queue();
                if(gamerList.contains(event.getMember().getEffectiveName())){
                    gamerList.remove(event.getMember().getEffectiveName());
                }
                break;
            case "list":

                StringBuilder list = new StringBuilder();
                gamerList.stream().forEach(gamer -> {
                    log.info("gamer = {}", gamer);
                    list.append(gamer);
                    list.append("\n");
                });
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("게임 참가자 목록");
                embed.setDescription(list);
                event.getChannel().sendMessageEmbeds(embed.build()).queue();

                break;
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.isFromType(ChannelType.TEXT)) {
            log.info("입력한 대화 = {}", event.getMessage().getContentDisplay());

            if(event.getMessage().getContentDisplay().equals("게임 시작")) {
                Button start = Button.primary("start", "참여");
                Button cancel = Button.danger("cancel", "취소");
                Button list = Button.success("list", "목록");
                event.getChannel().sendMessage("마피아 게임 참가하실려면 시작 버튼을 눌러주세요. ").addActionRow(start, cancel, list).queue();
            }

            if(event.getMessage().getContentDisplay().equals("시작")) {
                RoleAction role = new RoleActionImpl(event.getGuild());
                role.setName("마피아");
                role.setColor(Color.CYAN);
                role.queue();
            }

            if(event.getMessage().getContentDisplay().equals("신입받아라")) {
                List<Role> newRoles = new ArrayList<>(event.getMember().getRoles());
                newRoles.add(event.getGuild().getRolesByName("마피아",true).get(0));
                event.getGuild().modifyMemberRoles(event.getMember(),  newRoles).queue();
            }
        }
    }
}
