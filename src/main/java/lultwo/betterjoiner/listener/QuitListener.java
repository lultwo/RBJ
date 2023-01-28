package lultwo.betterjoiner.listener;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import lultwo.betterjoiner.utils.FileConfig;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        FileConfig config = new FileConfig("config.yml");

        String LeaveText = config.getString("Leave.Message");
        LeaveText = PlaceholderAPI.setPlaceholders(event.getPlayer(), LeaveText);
        event.setQuitMessage(LeaveText.toString());
    }
}
