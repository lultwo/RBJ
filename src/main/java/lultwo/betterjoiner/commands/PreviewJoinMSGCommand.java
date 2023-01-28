package lultwo.betterjoiner.commands;

import lultwo.betterjoiner.utils.FileConfig;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PreviewJoinMSGCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            FileConfig config = new FileConfig("config.yml");
            String PRF = config.getString("rbj.Prefix");

            if (player.hasPermission("rbj.previews")) {
                if (command.getName().equalsIgnoreCase("previewjoinmsg")) {
                    String PRVM = config.getString("Join.PrivateMessage");
                    PRVM = PlaceholderAPI.setPlaceholders(player.getPlayer(), PRVM);

                    player.sendMessage(PRVM);
                }
            } else {
                player.sendMessage(PRF + " " + config.getString("rbj.NoPermissions"));
            }
        }

        return false;
    }
}