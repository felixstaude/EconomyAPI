package felixstaude.economyapi.files;

import felixstaude.economyapi.sql.SQLEconomyConnection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class SQLFileGetterSetter {

    public FileConfiguration sqlcfg = getSQLFileConfiguration();
    public File getSQLFile() {
        return new File("plugins/EconomySystem", "mysql.yml");
    }
    public FileConfiguration getSQLFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getSQLFile());
    }
    public void setSQLDefault() {

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

    public void readSQLData(){
        SQLEconomyConnection.host = sqlcfg.getString("host");
        SQLEconomyConnection.database = sqlcfg.getString("database");
        SQLEconomyConnection.port = sqlcfg.getString("port");
        SQLEconomyConnection.username = sqlcfg.getString("username");
        SQLEconomyConnection.password = sqlcfg.getString("password");
    }
}
