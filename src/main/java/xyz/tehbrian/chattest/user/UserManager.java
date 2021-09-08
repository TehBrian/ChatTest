package xyz.tehbrian.chattest.user;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {

    public static final UUID CONSOLE = new UUID(0, 0);

    private final @NonNull Map<@NonNull UUID, @NonNull User> userMap = new HashMap<>();

    public @NonNull User getUser(final UUID uuid) {
        this.userMap.computeIfAbsent(uuid, User::new);
        return this.userMap.get(uuid);
    }

    public @NonNull User getUser(final Player player) {
        return this.getUser(player.getUniqueId());
    }

    public @NonNull User getUser(final CommandSender sender) {
        if (sender instanceof Player player) {
            return this.getUser(player);
        } else {
            return this.getUser(CONSOLE);
        }
    }

    public @NonNull Map<@NonNull UUID, @NonNull User> getUserMap() {
        return this.userMap;
    }

}
