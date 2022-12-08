package felixstaude.economyapi.files;

import felixstaude.economyapi.economyapi.EncoderDecoder;
import felixstaude.economyapi.language.Language;
import felixstaude.economyapi.sql.SQLEconomyConnection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileHandler {
    FileConfiguration sqlcfg = getSQLFileConfiguration();
    EncoderDecoder base64 = new EncoderDecoder();

    // sql config

    public void setSQLStandard() {

        sqlcfg.options().copyDefaults(true);

        sqlcfg.addDefault("host", "localhost");
        sqlcfg.addDefault("port", "3306");
        sqlcfg.addDefault("database", "economysystem");
        sqlcfg.addDefault("username", "user1");
        sqlcfg.addDefault("password", "passwd");
        try {
            sqlcfg.save(getSQLFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getSQLFile() {
        return new File("plugins/EconomySystem", "mysql.yml");
    }

    private FileConfiguration getSQLFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getSQLFile());
    }

    public void readSQLData(){
        SQLEconomyConnection.host = sqlcfg.getString("host");
        SQLEconomyConnection.database = sqlcfg.getString("database");
        SQLEconomyConnection.port = sqlcfg.getString("port");
        SQLEconomyConnection.username = sqlcfg.getString("username");
        SQLEconomyConnection.password = sqlcfg.getString("password");
     }

     // data config

    static FileConfiguration datacfg = getDataFileConfiguration();

    private static File getDataFile(){
        return new File("plugins/EconomySystem", "data.yml");
    }
    private static FileConfiguration getDataFileConfiguration(){
        return YamlConfiguration.loadConfiguration(getDataFile());
    }

    public static void readDataData(){
        Language.langString = datacfg.getString("language");
    }

    public void setDataStandart(){
        datacfg.addDefault(base64.getEncodedString("firststartup"), base64.getEncodedString("false"));
        datacfg.addDefault("language", "german");
    }

    // get language file

    public static File getLanguageFile(String language){
        if(language.equalsIgnoreCase("german")){
            return getGERFile();
        } else if(language.equalsIgnoreCase("english")){
            return getENGFile();
        }
        return getENGFile();
    }


    // german language file
    static FileConfiguration gercfg = getGERFileConfiguration();

    private static File getGERFile(){
        return new File("plugins/EconomySystem/languages", "german.yml");
    }
    private static FileConfiguration getGERFileConfiguration(){
        return YamlConfiguration.loadConfiguration(getGERFile());
    }

    public void setGERStandart(){
        // standart german file

    }

    // english language file
    static FileConfiguration engcfg = getENGFileConfiguration();

    private static File getENGFile(){
        return new File("plugins/EconomySystem/languages", "english.yml");
    }

    private static FileConfiguration getENGFileConfiguration(){
        return YamlConfiguration.loadConfiguration(getENGFile());
    }

    public void setENGStandart(){
        // standart english file
        engcfg.addDefault("error1001", "can't find the language file, check your settings.yml to set the correct language!");
    }

}
