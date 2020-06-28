package xyz.tehbrian.chattest.user;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class UserData {

    private final UUID uuid;

    private boolean colorEnabled = false;

    public UserData(final UUID uuid) {
        this.uuid = uuid;

        if (getPlayer() != null && getPlayer().hasPermission("chattest.ctc")) {
            colorEnabled = true;
        }

        if (this.uuid.equals(new UUID(0, 0))) {
            colorEnabled = true;
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public boolean hasColorEnabled() {
        return colorEnabled;
    }

    public void setColorEnabled(boolean colorEnabled) {
        this.colorEnabled = colorEnabled;
    }

    public boolean toggleColorEnabled() {
        setColorEnabled(!hasColorEnabled());
        return hasColorEnabled();
    }
}
