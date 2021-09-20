package xyz.tehbrian.chattest.commands;

import net.kyori.adventure.audience.Audience;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import xyz.tehbrian.chattest.ChatTest;
import xyz.tehbrian.chattest.user.User;

public class ChatTestColorCommand implements CommandExecutor {

    private final ChatTest chatTest;

    public ChatTestColorCommand(final ChatTest chatTest) {
        this.chatTest = chatTest;
    }

    @Override
    public boolean onCommand(
            final @NotNull CommandSender sender,
            final @NotNull Command command,
            final @NotNull String label,
            final @NotNull String[] args
    ) {
        final User user = this.chatTest.getUserService().getUser(sender);
        final Audience audience = this.chatTest.getBukkitAudiences().sender(sender);

        if (user.toggleColorEnabled()) {
            audience.sendMessage(this.chatTest.getMessage("messages.ctc.enabled"));
        } else {
            audience.sendMessage(this.chatTest.getMessage("messages.ctc.disabled"));
        }

        return true;
    }

}
