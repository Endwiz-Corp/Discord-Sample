package fr.endwiz.bot.sample.core.commands;

public enum CmdPermission {
    USER(1),
    ADMIN(3),
    OWNER(9);

    private final int level;

    CmdPermission(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
}
