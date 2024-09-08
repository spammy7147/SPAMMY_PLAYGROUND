package discord.bot;

import discord.event.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

@Component
public class BotConfig {

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

    @Bean
    public JDA getJDA() {
        return JDABuilder.createLight(BotToken.DISCORD_BOT_TOKEN, intents)
                // On this builder, you are adding all your event listeners and session configuration
                .addEventListeners(new MessageEvent())
                // You can do lots of configuration before starting, checkout all the setters on the JDABuilder class!
                .setActivity(Activity.watching("뿌엉"))
                // Once you're done configuring your jda instance, call build to start and login the bot.
                .build();
    };
}
