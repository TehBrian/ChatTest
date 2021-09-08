package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.tehbrian.chattest.ChatTest;
import xyz.tehbrian.chattest.user.User;

import java.util.UUID;

public class ChatTestColorCommand implements CommandExecutor {

    private final ChatTest main;

    public ChatTestColorCommand(final ChatTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final User user;
        if (sender instanceof Player) {
            user = this.main.getUserManager().getUser((Player) sender);
        } else {
            user = this.main.getUserManager().getUser(new UUID(0, 0));
        }

        if (user.toggleColorEnabled()) {
            sender.sendMessage(this.main.getMessage("messages.ctc.enabled"));
        } else {
            sender.sendMessage(this.main.getMessage("messages.ctc.disabled"));
        }

        return true;
    }

}
