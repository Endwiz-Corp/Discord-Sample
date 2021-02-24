package fr.endwiz.bot.sample.core.commands;

public enum CmdCategory {

    UTILS("Utility"),
    ADMIN("Admin"),
    FUN("Fun"),
    OWNER("Owner");

    private final String name;

    CmdCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
