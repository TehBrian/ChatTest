package xyz.tehbrian.chattest;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.checkerframework.checker.nullness.qual.NonNull;

public class FormatUtil {

    private FormatUtil() {
    }

    public static @NonNull Component legacy(final String string) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(string);
    }

    public static @NonNull Component plain(final String string) {
        return PlainTextComponentSerializer.plainText().deserialize(string);
    }

}
