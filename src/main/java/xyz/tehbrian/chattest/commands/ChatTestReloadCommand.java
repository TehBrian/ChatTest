package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tehbrian.chattest.ChatTest;

public class ChatTestReloadCommand implements CommandExecutor {

    private final ChatTest main;

    public ChatTestReloadCommand(final ChatTest main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        main.reloadConfig();
        sender.sendMessage(main.getMessage("messages.ctr"));

        return true;
    }

}
