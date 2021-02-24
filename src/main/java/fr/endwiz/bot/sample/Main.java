package fr.endwiz.bot.sample;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.User;
import fr.endwiz.bot.sample.core.commands.MsgProcessor;
import fr.endwiz.bot.sample.utils.EndwizLogger;
import fr.endwiz.bot.sample.utils.Json;

import java.io.File;

public class Main {

    private static int guildCounts;
    private static String bot_name = "Discord Sample";
    private static String prefix = "*";
    private static String token = "";
    private static String owner_id = "";

    public static EndwizLogger logger;

    public static void main(String[] args) {
        logger = new EndwizLogger(getName() + " Logger", EndwizLogger.ANSI_PURPLE);

        DiscordClient client = DiscordClient.builder(getToken()).build();
        GatewayDiscordClient gateway = client.login().block();

        User owner = gateway.getUserById(Snowflake.of(getOwnerId())).block();

        logger.log("Token: " + getToken());
        logger.log("Owner: " + owner.getTag());
        logger.log("Name: " + getName());
        logger.log("Prefix: " + getPrefix());

        gateway.getEventDispatcher().on(MessageCreateEvent.class).subscribe(MsgProcessor::processEvent);
        gateway.getEventDispatcher().on(ReadyEvent.class).subscribe(readyEvent -> guildCounts = gateway.getGuilds().collectList().block().size());

        gateway.onDisconnect().block();
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getToken() {
        return token;
    }

    public static String getName() {
        return bot_name;
    }

    public static String getOwnerId() { return owner_id;}
}
