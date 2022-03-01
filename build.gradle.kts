plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("org.checkerframework") version "0.6.8"
}

group = "xyz.tehbrian"
version = "1.1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()

    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "spigotmc"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
    maven("https://s01.oss.sonatype.org/content/groups/public/") {
        name = "sonatype-s01"
    }
    maven("https://repo.thbn.me/snapshots/") {
        name = "thbn-snapshots"
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.17.1-R0.1-SNAPSHOT")

    implementation("net.kyori:adventure-platform-bukkit:4.1.0")
    implementation("net.kyori:adventure-text-serializer-plain:4.10.0")

    implementation("dev.tehbrian:tehlib-paper:0.1.0-SNAPSHOT") {
        exclude(group = "cloud.commandframework")
        exclude(group = "org.apache.logging.log4j")
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "net.kyori", module = "adventure-text-minimessage")
    }
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }

    shadowJar {
        archiveBaseName.set("LegacyChatTest")

        relocate("net.kyori.adventure", "xyz.tehbrian.legacychattest.lib.adventure")
    }
}
