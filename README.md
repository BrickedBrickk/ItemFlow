# ItemFlow

A Fabric mod that tracks container changes on your Minecraft server and writes them to per-container log files.

## About

ItemFlow records what players put into and take out of containers on your server. When a player opens a chest, barrel, or shulker box, ItemFlow snapshots the contents. When the container is closed, it compares the before and after contents and appends any added or removed items to a log file for that container. It also logs container breaks and hopper placements underneath containers.

All logging happens automatically in the background. There are no commands and no configuration files.

## Features

- **Chest tracking** — logs items added and removed when a player closes a chest, including both halves of a double chest (each half gets its own log file).
- **Barrel tracking** — logs item changes when a player closes a barrel.
- **Shulker box tracking** — logs item changes when a player closes a shulker box.
- **Container break logging** — logs when a player breaks a container.
- **Hopper placement logging** — logs when a player places a hopper underneath a container.
- **Per-container log files** — each container gets its own log file, organized by dimension.
- **Automatic setup** — the log folder structure is created automatically when the server starts.

## Requirements

- ItemFlow v1.0.3
- Minecraft 26.3
- Fabric Loader (0.19.5 or newer)
- Fabric API (0.161.0+26.3 or newer)
- Java 25

## Installation

1. Install the appropriate Fabric Loader for Minecraft 26.3.
2. Install Fabric API.
3. Put `itemflow-1.0.3.jar` into your `mods` folder.
4. Launch the game or server.

ItemFlow is designed for servers. It also works in singleplayer, where logs are written to the world save.

## Usage

ItemFlow operates automatically. Once installed, it does the following:

- When a player closes a chest, barrel, or shulker box with changed contents, it appends the timestamp, player name, and the items added and removed to that container's log file.
- When a player breaks a container, it logs the event to that container's log file.
- When a player places a hopper underneath a container, it logs the event to that container's log file.

There are no commands and no configuration files.

### Log location

Log files are stored inside the world save directory:

```
<world save>/ChestLog/
├── Overworld/
├── The Nether/
└── The End/
```

Each container is logged to its own file named after the block and its coordinates, for example:

```
Chest 128 64 -304
```

A log entry looks like:

```
[23.09.26  14:30:00] PlayerName
Items Added: [3 minecraft:diamond]
Items Removed: [1 minecraft:stone]
```

## Building From Source

```
git clone https://github.com/BrickedBrickk/ItemFlow.git
cd ItemFlow
```

Windows:

```
gradlew.bat build
```

Linux/macOS:

```
./gradlew build
```

The compiled jars are generated in `build/libs/`.

## Credits

This project is based on [idkimanerd/ChestLogs](https://github.com/idkimanerd/ChestLogs),
which is an updated fork of [Aguga2201/ChestLogs](https://github.com/Aguga2201/ChestLogs),
which was heavily inspired by the original [ChestLogger on CurseForge](https://www.curseforge.com/minecraft/mc-mods/chestlogger).

## License

This project is licensed under the [MIT License](LICENSE.txt).
