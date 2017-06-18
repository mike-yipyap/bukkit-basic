package mcpluginexp;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainPluginListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Main.getInstance().getLogger().info("MainPluginListener.onBlockPlace");

        Player p = event.getPlayer();
        Block bp = event.getBlockPlaced();

        Main.getInstance().getLogger().info(String.format("X: %d Y: %d Z: %d block: %s", bp.getX(), bp.getY(), bp.getZ(), bp.getType().toString()));
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Main.getInstance().getLogger().info("MainPluginListener.onPlayerInteractEvent");

        Player player = event.getPlayer();

        if(player == null) {
            Main.getInstance().getLogger().info("MainPluginListener.onPlayerInteractEvent -- Player was null.");
            return;
        }

        Integer x = player.getLocation().getBlockX();
        Integer y = player.getLocation().getBlockY();
        Integer z = player.getLocation().getBlockZ();

        Main.getInstance().getLogger().info(String.format("Player Location X: %d Y: %d Z: %d", x, y, z));

        setTimeDay();
        setWeatherClear();

    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Main.getInstance().getLogger().info("MainPluginListener.onPlayerJoinEvent");

        Player player = event.getPlayer();

        if(player == null) {
            Main.getInstance().getLogger().info("MainPluginListener.onPlayerJoinEvent -- Player was null.");
            return;
        }

        World world = Bukkit.getWorld("spawn_world");
        player.teleport(world.getSpawnLocation());

    }



    private void setTimeDay() {
        Main.getInstance().getLogger().info("MainPluginListener.setTimeDay");

        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set 1000");

    }

    private void setWeatherClear() {
        Main.getInstance().getLogger().info("MainPluginListener.setWeatherClear");

        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather clear 1000000");

    }

}
