package mcpluginexp;

import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public static void setInstance(Main instance) {
        Main.instance = instance;
    }

    // region Constructor
    public Main() {
        getLogger().info("Main.Main");

    }
    // endregion

    // region Override Functions
    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().info("Main.onEnable");

        Main.instance = this;

        getServer().getPluginManager().registerEvents(new MainPluginListener(), this);
        getCommand("test").setExecutor(new MainCommands());

        generateWorlds();
    }

    @Override
    public void onDisable() {
        getLogger().info("Main.onDisable");


        super.onDisable();
    }
    // endregion

    private void generateWorlds() {
        getLogger().info("Main.generateWorlds");

        World world = Bukkit.getWorld("spawn_world");
        if (world == null) {
            getLogger().info("Main.generateWorlds -- spawn_world does not exist. creating...");
            WorldCreator worldCreator = new WorldCreator("spawn_world");
            worldCreator.environment(World.Environment.NORMAL);
            worldCreator.generateStructures(false);
            worldCreator.type(WorldType.FLAT);
            world = worldCreator.createWorld();
            world.setDifficulty(Difficulty.PEACEFUL);
        }

        world = Bukkit.getWorld("master_world");
        if (world == null) {
            getLogger().info("Main.generateWorlds -- master_world does not exist. creating...");
            WorldCreator worldCreator = new WorldCreator("master_world");
            worldCreator.environment(World.Environment.NORMAL);
            worldCreator.generateStructures(false);
            worldCreator.type(WorldType.NORMAL);
            world = worldCreator.createWorld();
            world.setDifficulty(Difficulty.PEACEFUL);
        }

        world = Bukkit.getWorld("amped");
        if (world == null) {
            getLogger().info("Main.generateWorlds -- amped does not exist. creating...");
            WorldCreator worldCreator = new WorldCreator("amped");
            worldCreator.environment(World.Environment.NORMAL);
            worldCreator.generateStructures(false);
            worldCreator.seed(1585554788);
            worldCreator.type(WorldType.AMPLIFIED);
            world = worldCreator.createWorld();
            world.setDifficulty(Difficulty.PEACEFUL);
        }

    }
}

