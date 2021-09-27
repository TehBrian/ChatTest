package xyz.tehbrian.legacychattest.user;

import dev.tehbrian.tehlib.paper.user.PaperUser;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

public class User extends PaperUser {

    private boolean colorEnabled = false;

    public User(final @NonNull UUID uuid) {
        super(uuid);

        final @Nullable Player player = this.getPlayer();
        if ((player != null && player.hasPermission("legacychattest.ctc"))
                || this.uuid.equals(UserService.CONSOLE)) {
            this.colorEnabled = true;
        }
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
