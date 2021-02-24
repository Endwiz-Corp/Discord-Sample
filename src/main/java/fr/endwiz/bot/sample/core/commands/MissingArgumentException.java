package fr.endwiz.bot.sample.core.commands;

public class MissingArgumentException extends RuntimeException {

    public MissingArgumentException() {
        super("Missing Argument Exception", null, false, false);
    }

}
