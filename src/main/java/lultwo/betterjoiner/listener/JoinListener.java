package lultwo.betterjoiner.listener;

import me.clip.placeholderapi.PlaceholderAPI;
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

        String PRVM = config.getString("PrivateMessage");
        PRVM = PlaceholderAPI.setPlaceholders(event.getPlayer(), PRVM);

        String JoinText = config.getString("JoinMessage");
        JoinText = PlaceholderAPI.setPlaceholders(event.getPlayer(), JoinText);


        event.setJoinMessage(JoinText.toString());
        event.getPlayer().sendMessage(PRVM);
    }
}
