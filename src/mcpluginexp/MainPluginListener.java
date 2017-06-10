package mcpluginexp;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static org.bukkit.Bukkit.getLogger;

/**
 * Created by mkooiker on 6/7/17.
 */
public class MainPluginListener implements Listener {

    private final String TAG = "MainPluginListener.";

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        getLogger().info(String.format("%s.%s", TAG, "onBlockPlace"));

        Player p = event.getPlayer();
        Block bp = event.getBlockPlaced();

        p.sendMessage(String.format("X: %d Y: %d Z: %d block: %s", bp.getX(), bp.getY(), bp.getZ(), bp.getType().toString()));
    }

}
