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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

@Slf4j
public class MessageEvent extends ListenerAdapter {




    @Override
    public void onReady(ReadyEvent event) {
        log.info("On Ready : {}", event);
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        event.deferEdit().queue();
        log.info("button ID = {}",event.getButton().getId());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.isFromType(ChannelType.TEXT)) {
            log.info("입력한 대화 = {}", event.getMessage().getContentDisplay());
            if(event.getMessage().getContentDisplay().equals("시작")) {
                EmbedBuilder hello = new EmbedBuilder();
                hello.setTitle("welcome");
                hello.setColor(0x66d8ff);
                hello.setDescription("이게뭘까");

                event.getChannel().sendMessageEmbeds(hello.build()).queue();

                Button button1 = Button.danger("button1", "버튼");
                Button button2 = Button.danger("button2", "버튼");
                Button button3 = Button.danger("button3", "버튼");
                event.getChannel().sendMessage("버튼 테스트").addActionRow(button1,button2, button3).queue();
            }

            if(event.getMessage().getContentDisplay().equals("신입받아라")) {
              RoleAction role = new RoleActionImpl(event.getGuild());
              role.setName("분노의코딩중");
              role.setColor(Color.CYAN);
              log.info("permission = {}", Permission.ALL_TEXT_PERMISSIONS);
              role.setPermissions(Permission.ALL_TEXT_PERMISSIONS);
              role.queue();
              //event.getGuild().addRoleToMember(event.getMember().getUser(), event.getGuild().getRolesByName("NEW", false).get(0));
                List<Role> roles = event.getMember().getRoles();
                roles.forEach( e -> {log.info("role = {}", e.getName());});
                log.info("size = {}",event.getGuild().getRolesByName("NEW", true).size());
                List<Role> aNew = event.getGuild().getRolesByName("NEW", true);
                log.info("{}",aNew);
                Role roleById = event.getGuild().getRoleById(aNew.get(0).getId());

                log.info("aNew instanceof ArrayList = {}",aNew instanceof ArrayList);
                log.info("aNew instanceof LinkedList = {}",aNew instanceof LinkedList);
                log.info("aNew instanceof Vector = {}",aNew instanceof Vector);
                log.info("roles size = {}",roles.size());
                log.info("role info = {}" , roleById);
                roles.add(roleById);

                List<Role> roles1 = event.getGuild().getRolesByName("NEW", true);
                roles1.forEach( e -> {log.info("role1 = {}", e.getName());});

                event.getGuild().modifyMemberRoles(event.getMember(),  roles);
            }

            log.info("test = {} ", event.getAuthor().getName());
        }
    }
}
