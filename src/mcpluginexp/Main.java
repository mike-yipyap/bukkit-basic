package mcpluginexp;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // region Constructor
    public Main() {
        getLogger().info("Main invoked.");

    }
    // endregion

    // region Override Functions
    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().info("Main.onEnable invoked.");

        // print out all players to terminal
        for(Player player : Bukkit.getServer().getOnlinePlayers()) {
            getLogger().info(String.format("Player %s is online.", player.getName()));
        }

        getServer().getPluginManager().registerEvents(new MainPluginListener(), this);
        getCommand("test").setExecutor(new MainCommands());

    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("Main.onDisable invoked.");

    }
    // endregion
}

