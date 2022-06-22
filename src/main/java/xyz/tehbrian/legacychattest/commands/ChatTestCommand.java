package xyz.tehbrian.legacychattest.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;
import xyz.tehbrian.legacychattest.LegacyChatTest;
import xyz.tehbrian.legacychattest.FormatUtil;
import xyz.tehbrian.legacychattest.user.User;

public final class ChatTestCommand implements CommandExecutor {

    private final LegacyChatTest chatTest;

    public ChatTestCommand(final LegacyChatTest chatTest) {
        this.chatTest = chatTest;
    }

    @Override
    public boolean onCommand(
            final @NotNull CommandSender sender,
            final @NotNull Command command,
            final @NotNull String label,
            final @NotNull String[] args
    ) {
        if (!this.chatTest.getConfig().getBoolean("allow_empty_messages")) {
            if (args.length == 0) {
                return false;
            }
        }

        final User user = this.chatTest.getUserService().getUser(sender);

        final String rawMessage = String.join(" ", args);

        final @NonNull Component message;
        if (user.colorEnabled()) {
            message = FormatUtil.legacy(rawMessage);
        } else {
            message = FormatUtil.plain(rawMessage);
        }

        this.chatTest.getBukkitAudiences().sender(sender).sendMessage(message);

        return true;
    }

}
