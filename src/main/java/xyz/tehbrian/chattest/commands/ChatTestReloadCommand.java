package xyz.tehbrian.chattest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tehbrian.chattest.ChatTest;

public class ChatTestReloadCommand implements CommandExecutor {

    private final ChatTest chatTest;

    public ChatTestReloadCommand(final ChatTest chatTest) {
        this.chatTest = chatTest;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        this.chatTest.reloadConfig();
        sender.sendMessage(this.chatTest.getMessage("messages.ctr"));

        return true;
    }

}
