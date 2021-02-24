package fr.endwiz.bot.sample.core.commands;

import fr.endwiz.bot.sample.Main;
import fr.endwiz.bot.sample.commands.PingCmd;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CmdManager {
    private static CmdManager instance;

    static {
        CmdManager.instance = new CmdManager();
    }

    private final Map<String, BaseCmd> commandsMap;

    private CmdManager() {
        this.commandsMap = CmdManager.initialize(
                //TODO Initialize your commands
                new PingCmd()
        );
    }

    private static Map<String, BaseCmd> initialize(BaseCmd... cmds) {
        final Map<String, BaseCmd> map = new LinkedHashMap<>();
        for (final BaseCmd cmd : cmds) {
            for (final String name : cmd.getNames()) {
                if (map.putIfAbsent(name, cmd) != null) {
                    Main.logger.warn("Collision between names of " + name + " and " + map.get(name).getClass().getSimpleName());
                }
            }
            cmd.setEnabled(true);
        }
        Main.logger.log(cmds.length + " commands initialized");
        return Collections.unmodifiableMap(map);
    }

    public Map<String, BaseCmd> getCommands() {
        return this.commandsMap;
    }

    public BaseCmd getCommand(String name) {
        return this.commandsMap.get(name);
    }

    public static CmdManager getInstance() {
        return instance;
    }

    public int getCommandsCount() {
        return getCommands().size();
    }
}
