package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.tehbrian.chattest.ChatTest;
import xyz.tehbrian.chattest.user.UserData;

import java.util.UUID;

public class ChatTestColorCommand implements CommandExecutor {

    private final ChatTest main;

    public ChatTestColorCommand(final ChatTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final UserData userData;
        if (sender instanceof Player) {
            userData = main.getUserDataManager().getUserData((Player) sender);
        } else {
            userData = main.getUserDataManager().getUserData(new UUID(0, 0));
        }

        if (userData.toggleColorEnabled()) {
            sender.sendMessage(main.getMessage("messages.ctc.enabled"));
        } else {
            sender.sendMessage(main.getMessage("messages.ctc.disabled"));
        }

        return true;
    }

}
