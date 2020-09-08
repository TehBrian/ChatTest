package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.tehbrian.chattest.ChatTest;
import xyz.tehbrian.chattest.user.UserData;
import xyz.tehbrian.chattest.util.MessageUtils;

import java.util.UUID;

public class ChatTestAllCommand implements CommandExecutor {

    private final ChatTest main;

    public ChatTestAllCommand(ChatTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!main.getConfig().getBoolean("allow_empty_messages")) {
            if (args.length == 0) {
                return false;
            }
        }

        String message = String.join(" ", args);

        UserData userData;
        if (sender instanceof Player) {
            userData = main.getUserDataManager().getUserData((Player) sender);
        } else {
            userData = main.getUserDataManager().getUserData(new UUID(0, 0));
        }

        if (userData.hasColorEnabled()) {
            message = MessageUtils.color(message);
        }

        sender.getServer().broadcastMessage(message);

        return true;
    }
}
