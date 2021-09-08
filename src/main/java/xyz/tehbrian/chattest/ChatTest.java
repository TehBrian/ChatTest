package xyz.tehbrian.chattest;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.tehbrian.chattest.commands.ChatTestAllCommand;
import xyz.tehbrian.chattest.commands.ChatTestColorCommand;
import xyz.tehbrian.chattest.commands.ChatTestCommand;
import xyz.tehbrian.chattest.commands.ChatTestReloadCommand;
import xyz.tehbrian.chattest.commands.NoTabComplete;
import xyz.tehbrian.chattest.user.UserDataManager;
import xyz.tehbrian.chattest.util.MessageUtils;

import java.util.Objects;

public final class ChatTest extends JavaPlugin {

    private UserDataManager userDataManager;

    @Override
    public void onEnable() {
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

    public String getMessage(final String configKey) {
        return MessageUtils.color(Objects.requireNonNull(getConfig().getString(configKey)));
    }

}
