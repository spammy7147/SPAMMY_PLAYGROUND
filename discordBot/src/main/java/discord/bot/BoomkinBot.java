package discord.bot;

import discord.BotToken;
import discord.event.MessageEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class BoomkinBot {
    public static void main(String[] args) {

        JDA jda = JDABuilder.createLight(BotToken.DISCORD_BOT_TOKEN, EnumSet.noneOf(GatewayIntent.class)) // slash commands don't need any intents
                .addEventListeners(new MessageEvent())
                .build();
    }
}