package lultwo.betterjoiner.utils;

import java.io.IOException;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileConfig extends YamlConfiguration {
    private String path;

    public FileConfig(String folder, String filename) {
        this.path = "plugins/" + folder + "/" + filename;

        try {
            this.load(this.path);
        } catch (IOException | InvalidConfigurationException var4) {
            var4.printStackTrace();
        }

    }

    public FileConfig(String filename) {
        this("RBJ", filename);
    }

    public void saveConfig() {
        try {
            this.save(this.path);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }
}