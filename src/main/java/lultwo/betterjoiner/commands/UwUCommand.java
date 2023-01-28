package lultwo.betterjoiner.commands;

import lultwo.betterjoiner.utils.FileConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UwUCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;

            player.sendMessage("§dUwU \n\n§8One UwU a Day keeps the Doctor away!");
        }
        return false;
    }
}
