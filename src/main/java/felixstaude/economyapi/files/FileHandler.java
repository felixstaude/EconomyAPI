package felixstaude.economyapi.files;

import felixstaude.economyapi.economyapi.EncoderDecoder;
import felixstaude.economyapi.sql.SQLEconomyConnection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileHandler {
    FileConfiguration sqlcfg = getSQLFileConfiguration();
    EncoderDecoder base64 = new EncoderDecoder();

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
}
