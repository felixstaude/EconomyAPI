package felixstaude.economyapi.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigFileGetterSetter {

    public FileConfiguration configcfg = getConfigFileConfiguration();
    public File getConfigFile(){return new File("plugins/EconomySystem", "config.yml");}
    public FileConfiguration getConfigFileConfiguration(){
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public void setConfigDefault(){
        configcfg.addDefault("DebugMode", "false");
    }

    public boolean getDebugMode(){return configcfg.getBoolean("DebugMode");}
    public void setDebugMode(boolean debugMode){configcfg.set("DebugMode", debugMode);}
}
