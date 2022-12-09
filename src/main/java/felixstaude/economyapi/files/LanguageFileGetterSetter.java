package felixstaude.economyapi.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LanguageFileGetterSetter {

    public File getLanguageFile(String language){
        if(language.equalsIgnoreCase("german")){
            return getGERFile();
        } else if(language.equalsIgnoreCase("english")){
            return getENGFile();
        }
        return getENGFile();
    }

    public File getGERFile(){return new File("plugins/EconomySystem/languages", "german.yml");}
    public FileConfiguration getGERFileConfiguration(){return YamlConfiguration.loadConfiguration(getGERFile());}

    public File getENGFile(){return new File("plugins/EconomySystem/languages", "english.yml");}
    public FileConfiguration getENGFileConfiguration(){return YamlConfiguration.loadConfiguration(getENGFile());}

    public void setDefault(){
        LanguageDefault languageDefault = new LanguageDefault();
        languageDefault.setENGDefault();
        languageDefault.setENGDefault();
    }
}
