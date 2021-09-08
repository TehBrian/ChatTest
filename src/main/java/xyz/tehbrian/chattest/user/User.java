package xyz.tehbrian.chattest.user;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

public class User {

    private final @NonNull UUID uuid;

    private boolean colorEnabled = false;

    public User(final @NonNull UUID uuid) {
        this.uuid = uuid;

        final @Nullable Player player = this.getPlayer();
        if ((player != null && player.hasPermission("chattest.ctc"))
                || this.uuid.equals(UserManager.CONSOLE)) {
            this.colorEnabled = true;
        }
    }

    public @NonNull UUID getUuid() {
        return this.uuid;
    }

    public @Nullable Player getPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }

    public boolean colorEnabled() {
        return this.colorEnabled;
    }

    public void colorEnabled(final boolean colorEnabled) {
        this.colorEnabled = colorEnabled;
    }

    public boolean toggleColorEnabled() {
        this.colorEnabled(!this.colorEnabled());
        return this.colorEnabled();
    }

}
