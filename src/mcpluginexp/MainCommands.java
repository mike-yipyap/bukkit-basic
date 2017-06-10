package mcpluginexp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by mkooiker on 6/7/17.
 */
public class MainCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String commandLabel, String[] strings) {
        if (commandLabel.equalsIgnoreCase("test")) {
            commandSender.sendMessage("You just send me a command.");
            return true;
        }
        return false;
    }
}
