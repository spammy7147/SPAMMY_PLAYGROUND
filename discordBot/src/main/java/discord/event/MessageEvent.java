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
     * hello.setDescription("????????????");
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
                event.getMember().getUser().openPrivateChannel().flatMap( channel -> channel.sendMessage("????????? ????????? ?????????????????????.")).queue();
                log.info("nickName = {}", event.getMember().getEffectiveName());
                gamerList.add(event.getMember().getEffectiveName());
                break;
            case "cancel":
                event.getMember().getUser().openPrivateChannel().flatMap( channel -> channel.sendMessage("?????? ????????? ??????????????????.")).queue();
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
                embed.setTitle("?????? ????????? ??????");
                embed.setDescription(list);
                event.getChannel().sendMessageEmbeds(embed.build()).queue();

                break;
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.isFromType(ChannelType.TEXT)) {
            log.info("????????? ?????? = {}", event.getMessage().getContentDisplay());

            if(event.getMessage().getContentDisplay().equals("?????? ??????")) {
                Button start = Button.primary("start", "??????");
                Button cancel = Button.danger("cancel", "??????");
                Button list = Button.success("list", "??????");
                event.getChannel().sendMessage("????????? ?????? ?????????????????? ?????? ????????? ???????????????. ").addActionRow(start, cancel, list).queue();
            }

            if(event.getMessage().getContentDisplay().equals("??????")) {
                RoleAction role = new RoleActionImpl(event.getGuild());
                role.setName("?????????");
                role.setColor(Color.CYAN);
                role.queue();
            }

            if(event.getMessage().getContentDisplay().equals("???????????????")) {
                List<Role> newRoles = new ArrayList<>(event.getMember().getRoles());
                newRoles.add(event.getGuild().getRolesByName("?????????",true).get(0));
                event.getGuild().modifyMemberRoles(event.getMember(),  newRoles).queue();
            }
        }
    }
}
