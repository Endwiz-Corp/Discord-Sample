package fr.endwiz.bot.sample.core.commands;

import reactor.util.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class BaseCmd {

    private final CmdCategory category;
    private final CmdPermission permission;
    private final List<String> names;
    @Nullable
    private final String alias;

    private boolean isEnabled;

    protected BaseCmd(CmdCategory category, CmdPermission permission, List<String> names, @Nullable String alias){
        this.category = category;
        this.permission = permission;
        this.names = new ArrayList<>(names);
        this.alias = alias;

        if (this.alias != null) { this.names.add(this.alias); }
    }

    protected BaseCmd(CmdCategory category, CmdPermission permission, List<String> names){
        this(category, permission, names, null);
    }

    protected BaseCmd(CmdCategory category, List<String> names, String alias) {
        this(category, CmdPermission.USER, names, alias);
    }

    protected BaseCmd(CmdCategory category, List<String> names) {
        this(category, names, null);
    }

    public abstract void execute(Context context);

    public CmdCategory getCategory() {
        return this.category;
    }

    public CmdPermission getPermission() {
        return this.permission;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(this.names);
    }

    public String getName() {
        return this.names.get(0);
    }

    @Nullable
    public Optional<String> getAlias() {
        return Optional.ofNullable(this.alias);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
