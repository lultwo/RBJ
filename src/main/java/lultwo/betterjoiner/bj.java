package lultwo.betterjoiner;

import lultwo.betterjoiner.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import lultwo.betterjoiner.listener.QuitListener;
import lultwo.betterjoiner.listener.JoinListener;
import lultwo.betterjoiner.utils.FileConfig;

public final class bj extends JavaPlugin {
    FileConfig config = new FileConfig("config.yml");
    public static String vers = "0.7.7pre Bronze";
    public static String author = "lultwo";

    public void onEnable() {

        this.saveDefaultConfig();
        this.saveConfig();
        this.getConfig();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getConsoleSender().sendMessage("RBJ is now using PlaceholderAPI! Have fun");
        } else {
            Bukkit.getConsoleSender().sendMessage("PlaceholderAPI is not installed! You need to download it upload it! Sorry");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        this.getCommand("rbj-rl").setExecutor(new ReloadCommand());
        this.getCommand("uwu").setExecutor(new UwUCommand());
        this.getCommand("previewjoin").setExecutor(new PreviewJoinCommand());
        this.getCommand("previewjoinmsg").setExecutor(new PreviewJoinMSGCommand());
        this.getCommand("previewleave").setExecutor(new PreviewLeaveCommand());

        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "---============================---");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY.toString() + ChatColor.UNDERLINE + ChatColor.BOLD + "Rhenium BetterJoiner");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "Plugin was enabled");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY.toString() + ChatColor.UNDERLINE + ChatColor.BOLD + "Version: " + vers + "  " + "Developer" + author);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "---============================---");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "---============================---");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY.toString() + ChatColor.UNDERLINE + ChatColor.BOLD + "Rhenium BetterJoiner");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Is now Disabled");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "---============================---");
    }
}