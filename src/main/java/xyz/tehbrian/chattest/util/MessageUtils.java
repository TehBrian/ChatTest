package xyz.tehbrian.chattest.util;

import org.bukkit.ChatColor;
import xyz.tehbrian.chattest.ChatTest;

public class MessageUtils {

    private MessageUtils() {
    }

    public static String color(String string) {
        return string == null ? null : ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String color(String string, char alternateColorCharacter) {
        return string == null ? null : ChatColor.translateAlternateColorCodes(alternateColorCharacter, string);
    }

    public static String getMessage(String configKey) {
        return color(ChatTest.getInstance().getConfig().getString(configKey));
    }
}
