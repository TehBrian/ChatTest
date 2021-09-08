package xyz.tehbrian.chattest.user;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class User {

    private final UUID uuid;

    private boolean colorEnabled = false;

    public User(final UUID uuid) {
        this.uuid = uuid;

        if (getPlayer() != null && this.getPlayer().hasPermission("chattest.ctc")) {
            this.colorEnabled = true;
        }

        if (this.uuid.equals(new UUID(0, 0))) {
            this.colorEnabled = true;
        }
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }

    public boolean hasColorEnabled() {
        return this.colorEnabled;
    }

    public void setColorEnabled(final boolean colorEnabled) {
        this.colorEnabled = colorEnabled;
    }

    public boolean toggleColorEnabled() {
        this.setColorEnabled(!this.hasColorEnabled());
        return this.hasColorEnabled();
    }

}
