package felixstaude.economyapi.files;

import felixstaude.economyapi.language.Language;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class DataFileGetterSetter {

    public FileConfiguration datacfg = getDataFileConfiguration();
    public File getDataFile(){
        return new File("plugins/EconomySystem", "data.yml");
    }
    public FileConfiguration getDataFileConfiguration(){
        return YamlConfiguration.loadConfiguration(getDataFile());
    }

    public void getDataData(){
        Language.langString = datacfg.getString("language");
    }

    public void setDataDefault(){
        datacfg.addDefault("firststartup","false");
        datacfg.addDefault("language", "german");
    }
}
