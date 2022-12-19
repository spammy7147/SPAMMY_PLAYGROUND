package discord.event;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
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
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.internal.requests.restaction.MessageCreateActionImpl;

@Slf4j
public class MessageEvent extends ListenerAdapter {




    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("onReadyEvent");
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        System.out.println(event.getName());
        switch (event.getName()) {
            case "say":
                System.out.println("say");
                event.getChannel().sendMessage("ho").queue();
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        event.deferEdit().queue();
        log.info("button ID = {}",event.getButton().getId());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.isFromType(ChannelType.TEXT)) {

            if(event.getMessage().getContentDisplay().equals("시작")) {
                EmbedBuilder hello = new EmbedBuilder();
                hello.setTitle("welcome");
                hello.setColor(0x66d8ff);
                hello.setDescription("이게뭘까");

                event.getChannel().sendMessageEmbeds(hello.build()).queue();

                Button button = Button.danger("button", "버튼");
                event.getChannel().sendMessage("버튼 테스트").addActionRow(button).queue();


            }

            System.out.println(event.getMessage().getContentDisplay());
            log.info("test = {} ", event.getAuthor().getName());

            if(event.getMessage().getContentDisplay().equals("//준식") && event.getGuild().getName().equals("오락")) {
                event.getChannel().sendMessage("준석").queue();
            }
        }
        else{
            System.out.printf("[PM] %#s: %s%n", event.getAuthor(), event.getMessage().getContentDisplay());
            System.out.println(event.getJDA().getGuildById("752897283455975614"));

            System.out.println(event.getChannel());
            System.out.println(event.getMember());
            System.out.println(event.getChannel().getName());

        }
    }
}
