package fr.endwiz.bot.sample.commands;

import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.object.reaction.ReactionEmoji;
import fr.endwiz.bot.sample.core.commands.BaseCmd;
import fr.endwiz.bot.sample.core.commands.CmdCategory;
import fr.endwiz.bot.sample.core.commands.CmdPermission;
import fr.endwiz.bot.sample.core.commands.Context;

import java.util.Arrays;

public class PingCmd extends BaseCmd {

    public PingCmd() {
        super(CmdCategory.UTILS, CmdPermission.USER, Arrays.asList("ping"));
    }

    @Override
    public void execute(Context context) {
        MessageChannel chan = context.getChannel();
        chan.createMessage("Pong!").block().addReaction(ReactionEmoji.unicode("✅")).block();
    }

}
