package lultwo.betterjoiner.listener;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import lultwo.betterjoiner.utils.FileConfig;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfig config = new FileConfig("config.yml");

        String PRVM = config.getString("Join.PrivateMessage");
        PRVM = PlaceholderAPI.setPlaceholders(event.getPlayer(), PRVM);

        String JoinText = config.getString("Join.Message");
        JoinText = PlaceholderAPI.setPlaceholders(event.getPlayer(), JoinText);

        event.setJoinMessage(JoinText.toString());
        event.getPlayer().sendMessage(PRVM);

        if (config.getBoolean("Join.Sound") == true){
            event.getPlayer().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 100, 0);
        }
    }
}
