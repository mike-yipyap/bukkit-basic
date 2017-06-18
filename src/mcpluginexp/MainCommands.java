package mcpluginexp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MainCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String commandLabel, String[] strings) {
        Main.getInstance().getLogger().info("MainCommands.onCommand");

        if (commandLabel.equalsIgnoreCase("test")) {
            Main.getInstance().getLogger().info("MainCommands.onCommand -- test command");
            commandSender.sendMessage("You just send me the test command.");
            return true;
        }

        if (commandLabel.equalsIgnoreCase("test2")) {
            Main.getInstance().getLogger().info("MainCommands.onCommand -- test2 command");
            commandSender.sendMessage("You just send me the test2 command.");
            return true;
        }
        return false;
    }
}
