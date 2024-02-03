package com.farthergate;

import java.net.MalformedURLException;
import java.net.URL;

import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var dotenv = Dotenv.load();

        var api = new DiscordApiBuilder()
            .setToken(dotenv.get("DISCORD_TOKEN"))
            .login().join();

        api.getServerChannelsByName("general").forEach(channel -> {
            try {
                new MessageBuilder()
                    .addEmbed(new EmbedBuilder()
                        .setImage("https://media1.tenor.com/m/159UhFAYBWEAAAAC/fiber-optic-friday-eat-the-optic-cable.gif"))
                    .send(channel.asTextChannel().orElseThrow());
            } catch(Exception ex) {}
        });
    }
}
