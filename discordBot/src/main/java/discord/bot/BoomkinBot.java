package discord.bot;

import discord.BotToken;
import discord.event.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;

import java.util.EnumSet;

public class BoomkinBot {
    public static void main(String[] args) {

        EnumSet<GatewayIntent> intents = EnumSet.of(
                // Enables MessageReceivedEvent for guild (also known as servers)
                GatewayIntent.GUILD_MESSAGES,
                // Enables the event for private channels (also known as direct messages)
                GatewayIntent.DIRECT_MESSAGES,
                // Enables access to message.getContentRaw()
                GatewayIntent.MESSAGE_CONTENT,
                // Enables MessageReactionAddEvent for guild
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                // Enables MessageReactionAddEvent for private channels
                GatewayIntent.DIRECT_MESSAGE_REACTIONS
        );


        JDA jda = JDABuilder.createLight(BotToken.DISCORD_BOT_TOKEN, intents)
                // On this builder, you are adding all your event listeners and session configuration
                .addEventListeners(new MessageEvent())
                // You can do lots of configuration before starting, checkout all the setters on the JDABuilder class!
                .setActivity(Activity.watching("뿌엉"))
                // Once you're done configuring your jda instance, call build to start and login the bot.
                .build();

    }



}