package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.tehbrian.chattest.ChatTest;
import xyz.tehbrian.chattest.user.User;
import xyz.tehbrian.chattest.util.MessageUtils;

import java.util.UUID;

public class ChatTestCommand implements CommandExecutor {

    private final ChatTest main;

    public ChatTestCommand(final ChatTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!this.main.getConfig().getBoolean("allow_empty_messages")) {
            if (args.length == 0) {
                return false;
            }
        }

        String message = String.join(" ", args);

        final User user;
        if (sender instanceof Player) {
            user = this.main.getUserManager().getUser((Player) sender);
        } else {
            user = this.main.getUserManager().getUser(new UUID(0, 0));
        }

        if (user.hasColorEnabled()) {
            message = MessageUtils.color(message);
        }

        sender.sendMessage(message);

        return true;
    }

}
