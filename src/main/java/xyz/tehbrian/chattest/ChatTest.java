package xyz.tehbrian.chattest;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.tehbrian.chattest.commands.*;
import xyz.tehbrian.chattest.user.UserDataManager;

public final class ChatTest extends JavaPlugin {

    private static ChatTest instance;

    private UserDataManager userDataManager;

    public static ChatTest getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        setupConfig();
        setupCommands();
    }

    private void setupConfig() {
        saveDefaultConfig();
    }

    private void setupCommands() {
        getCommand("ct").setExecutor(new ChatTestCommand(this));
        getCommand("cta").setExecutor(new ChatTestAllCommand(this));
        getCommand("ctc").setExecutor(new ChatTestColorCommand(this));
        getCommand("ctr").setExecutor(new ChatTestReloadCommand(this));

        // I'd like it if instead of player names, Minecraft wouldn't suggest
        // anything by default, but here we are.
        getCommand("ct").setTabCompleter(new NoTabComplete());
        getCommand("cta").setTabCompleter(new NoTabComplete());
        getCommand("ctc").setTabCompleter(new NoTabComplete());
        getCommand("ctr").setTabCompleter(new NoTabComplete());
    }

    public UserDataManager getUserDataManager() {
        if (userDataManager == null) {
            userDataManager = new UserDataManager();
        }
        return userDataManager;
    }
}
