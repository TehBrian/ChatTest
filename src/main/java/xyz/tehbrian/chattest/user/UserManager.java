package xyz.tehbrian.chattest.user;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {

    private final Map<UUID, User> userMap = new HashMap<>();

    public User getUser(final UUID uuid) {
        userMap.computeIfAbsent(uuid, User::new);
        return userMap.get(uuid);
    }

    public User getUser(final Player player) {
        return getUser(player.getUniqueId());
    }

    public Map<UUID, User> getUserMap() {
        return userMap;
    }

}
