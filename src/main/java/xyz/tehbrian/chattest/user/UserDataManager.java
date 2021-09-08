package xyz.tehbrian.chattest.user;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserDataManager {

    private final Map<UUID, UserData> userDataMap = new HashMap<>();

    public UserData getUserData(final UUID uuid) {
        userDataMap.computeIfAbsent(uuid, UserData::new);
        return userDataMap.get(uuid);
    }

    public UserData getUserData(final Player player) {
        return getUserData(player.getUniqueId());
    }

    public Map<UUID, UserData> getUserDataMap() {
        return userDataMap;
    }

}
