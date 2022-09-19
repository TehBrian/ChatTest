plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("net.kyori.indra.checkstyle") version "2.2.0"
}

group = "xyz.tehbrian"
version = "1.1.1"
description = "Easily test how legacy-formatted messages will look in chat."

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "spigotmc"
    }
    maven("https://repo.thbn.me/releases/") {
        name = "thbn"
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.18.2-R0.1-SNAPSHOT")

    implementation("net.kyori:adventure-platform-bukkit:4.1.2")
    implementation("net.kyori:adventure-text-serializer-plain:4.11.0")

    implementation("dev.tehbrian:tehlib-paper:0.3.1") {
        exclude(group = "cloud.commandframework")
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "net.kyori", module = "adventure-text-minimessage")
    }
}

tasks {
    assemble {
        dependsOn(shadowJar)
    }

    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version, "description" to project.description)
        }
    }

    shadowJar {
        archiveBaseName.set("LegacyChatTest")
        archiveClassifier.set("")

        val libsPackage = "xyz.tehbrian.legacychattest.libs"
        relocate("net.kyori.adventure", "$libsPackage.adventure")
        relocate("net.kyori.examination", "$libsPackage.examination")
        relocate("dev.tehbrian.tehlib", "$libsPackage.tehlib")
    }
}
