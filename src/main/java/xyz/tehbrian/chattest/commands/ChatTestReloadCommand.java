package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tehbrian.chattest.ChatTest;

public class ChatTestReloadCommand implements CommandExecutor {

    private final ChatTest main;

    public ChatTestReloadCommand(ChatTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        main.reloadConfig();
        sender.sendMessage(main.getMessage("messages.ctr"));

        return true;
    }
}
