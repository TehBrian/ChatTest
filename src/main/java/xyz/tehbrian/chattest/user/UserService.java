package xyz.tehbrian.chattest.user;

import dev.tehbrian.tehlib.paper.user.PaperUserService;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class UserService extends PaperUserService<User> {

    public static final UUID CONSOLE = new UUID(0, 0);

    @Override
    public @NonNull User getUser(final @NotNull UUID uuid) {
        return this.userMap.computeIfAbsent(uuid, User::new);
    }

    public @NonNull User getUser(final CommandSender sender) {
        if (sender instanceof Player player) {
            return this.getUser(player);
        } else {
            return this.getUser(CONSOLE);
        }
    }

}
