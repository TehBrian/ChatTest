package xyz.tehbrian.chattest;

import dev.tehbrian.tehlib.paper.TehPlugin;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import xyz.tehbrian.chattest.commands.ChatTestAllCommand;
import xyz.tehbrian.chattest.commands.ChatTestColorCommand;
import xyz.tehbrian.chattest.commands.ChatTestCommand;
import xyz.tehbrian.chattest.commands.ChatTestReloadCommand;
import xyz.tehbrian.chattest.user.UserService;

import java.util.Objects;

public final class ChatTest extends TehPlugin {

    private UserService userService;
    private BukkitAudiences bukkitAudiences;

    @Override
    public void onEnable() {
        this.setupConfig();
        this.setupCommands();
    }

    private void setupConfig() {
        saveDefaultConfig();
    }

    private void setupCommands() {
        this.registerCommand("ct", new ChatTestCommand(this));
        this.registerCommand("cta", new ChatTestAllCommand(this));
        this.registerCommand("ctc", new ChatTestColorCommand(this));
        this.registerCommand("ctr", new ChatTestReloadCommand(this));
    }

    public UserService getUserService() {
        if (this.userService == null) {
            this.userService = new UserService();
        }
        return this.userService;
    }

    public BukkitAudiences getBukkitAudiences() {
        if (this.bukkitAudiences == null) {
            this.bukkitAudiences = BukkitAudiences.create(this);
        }
        return this.bukkitAudiences;
    }

    public @NonNull Component getMessage(final String configKey) {
        return FormatUtil.legacy(Objects.requireNonNull(getConfig().getString(configKey)));
    }

}
