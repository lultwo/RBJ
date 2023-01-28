package lultwo.betterjoiner.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import lultwo.betterjoiner.utils.FileConfig;

public class ReloadCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            FileConfig config = new FileConfig("config.yml");
            String PRF = config.getString("rbj.Prefix");

            if (player.hasPermission("rbj.reload")) {
                if (command.getName().equalsIgnoreCase("rbj-rl")) {
                    player.sendMessage(PRF + config.getString("Commands.Reload"));
                    config.saveConfig();
                }
            } else {
                player.sendMessage(PRF + " " + config.getString("rbj.NoPermissions"));
            }
        }

        return false;
    }
}
