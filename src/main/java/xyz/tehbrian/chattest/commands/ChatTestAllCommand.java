package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tehbrian.chattest.ChatTest;
import xyz.tehbrian.chattest.user.User;
import xyz.tehbrian.chattest.util.MessageUtils;

public class ChatTestAllCommand implements CommandExecutor {

    private final ChatTest chatTest;

    public ChatTestAllCommand(final ChatTest chatTest) {
        this.chatTest = chatTest;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!this.chatTest.getConfig().getBoolean("allow_empty_messages")) {
            if (args.length == 0) {
                return false;
            }
        }

        String message = String.join(" ", args);

        final User user = this.chatTest.getUserManager().getUser(sender);

        if (user.colorEnabled()) {
            message = MessageUtils.color(message);
        }

        sender.getServer().broadcastMessage(message);

        return true;
    }

}
